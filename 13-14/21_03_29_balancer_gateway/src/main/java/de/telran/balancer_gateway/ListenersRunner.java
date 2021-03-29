package de.telran.balancer_gateway;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ListenersRunner implements ApplicationRunner {

    private final TcpOuterListener tcpOuterListener;
    private final UdpBalancerListener udpBalancerListener;

    public ListenersRunner(TcpOuterListener tcpOuterListener, UdpBalancerListener udpBalancerListener) {
        this.tcpOuterListener = tcpOuterListener;
        this.udpBalancerListener = udpBalancerListener;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        tcpOuterListener.run();
        udpBalancerListener.run();
    }
}
