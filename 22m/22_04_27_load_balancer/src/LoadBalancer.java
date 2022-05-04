// LoadBalancer
// 1. Лоад балансер слушает 3000 порт на прием UDP сообщений от серверов (каждый сервер знает, где находится лоад балансер)
// 2. Лоад балансер принимает информацию с серверов о их загрузке в следующем виде: "<server tcp port>:<load>",
// где <server tcp port> это порт, который открыт на сервере для обработки данных с Gateway.
// 3. Лоад балансер вытаскивает из датаграммы с сервера инормацию о сервере, а именно ip адрес, порт для tcp соединений с
// gateway и текущую нагрузку на сервер. Далее Лоад балансер сохраняет эту инцормацию внутри себя в определенную структуру данных,
// добавляя к информации о сервере timestamp (время получения информации о сервере).
// 4. Каждую секунду Лоад балансер производит самоочищение. Удалаяет из структуры данных информацию о тех серверах,
// которые не давали о себе знать одну секунду.
// 5. Каждые 100 милисекунд Лоад балансер отправляет информацию о наименее загруженном сервере на Gateway на порт 2001 в формате
// "<server host(ip)>:<server tcp port>"

// По архитектуре.
// 0. Необходима структура данных, хранящая информацию об актуальных серверах
// 1. На лоад балансере есть один поток для приема сообщений с серверов
// 2. Еще один поток необходим для очищения струкуры данных с серверами от отвалившихся серверов каждую секунду
// 3. Еще один поток необходим для отправки каждые 100 милисекунд информации об оптимальном сервере на Gateway через
// UDP датаграмму.


// Gateway
// 1. Gateway слушает 2000 порт для приема tcp соединений от клиентов (иными словами, открытый в интернете порт)
// 2. гейтвэй слушает 2001 порт для приема upd датаграм от лоад балансера
// 3. хранит информацию об оптимальном сервере, полученную от лоад балансера, и перенаправляет tcp соединения на
// оптимальный сервер.

// По архитектуре
// 0. Класса, содержаций информацию об оптимальном сервере
// 1. Необходим поток для приема датаграм с лоад балансера и обновления информации об оптимальном сервере
// 2. необходим поток, который принимает соединения с клиентов и добавляет таски в
// ThreadPool, обрабатывающие эти соединения. Каждый такой таск делает следующее: берет информацию об оптимальном
// сервере и устанавливает tcp соединение с этим сервером, далее перенаправляя данные с клиента к серверу, а затем
// ответы c сервера к клиенту.


// Server
// 1. Слушает кастомный tcp port (40xx) на прием и обработку данных от Gateway
// 2. Каждые 100 милисекунд отправляет UDP датаграмму на лоад балансер на порт 3000 о состоянии собственной загрузки
// в формате "<server tcp port>:<load>".

// По арзитектуре
// 0. объект, хранящий текущую нагрузку, доступный для потока отпраки датаграмм на лоад балансер
// 1. поток на отправку загрузки
// 2. поток на прием и обработку данных с гейтвея


import java.io.IOException;

public class LoadBalancer {

    private static final String DEFAULT_PROPS_PATH = "config/application.props";
    private static final String UDP_FROM_SERVER_PORT_KEY = "udp.balancer.port";
    private static final String UDP_TO_GATEWAY_PORT_KEY = "udp.gateway.port";
    private static final String GATEWAY_HOST_KEY = "gateway.host";

    public static void main(String... args) throws IOException {
        String propsPath = args.length > 0 ? args[0] : DEFAULT_PROPS_PATH;
        ApplicationProperties properties = new ApplicationProperties(propsPath);

        int udpServerPort = Integer.parseInt(properties.getProperty(UDP_FROM_SERVER_PORT_KEY));

        IServerMap serverMap = new ServerList();
        UdpServerListener udpServerListener = new UdpServerListener(serverMap, udpServerPort);
        new Thread(udpServerListener).start();

        int udpGatewayPort = Integer.parseInt(properties.getProperty(UDP_TO_GATEWAY_PORT_KEY));
        String gatewayHost = properties.getProperty(GATEWAY_HOST_KEY);
        UdpGatewaySender udpGatewaySender = new UdpGatewaySender(gatewayHost, serverMap, udpGatewayPort, 100);
        new Thread(udpGatewaySender).start();

        Cleaner cleaner = new Cleaner(serverMap, 1000);
        new Thread(cleaner).start();

    }
}
