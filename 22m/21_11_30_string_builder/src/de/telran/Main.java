package de.telran;

public class Main {

    public static void main(String[] args) {

        String helloWorld = "hello world";

        String res = "";

        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            res += helloWorld;
//            res = res.concat(helloWorld);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        // на каждой итерации происходит создание нового объекта строки, у которого внутри находится массив.
        // Далее, происходит поэлементное копирование символов из старого res в новый массив и еще 11 символов
        // тогда простейших операций в данном алгоритме будет 0 + 11 + 22 + 33 + ... + 110000 = 10001 * 110000 / 2 = 10001 * 55000
        // 0 + 1 + 2 + 3 + ... + 10 = 11 * 10 / 2

        StringBuilder sb = new StringBuilder();
        currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(helloWorld);
        }
        res = sb.toString();
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        StringBuffer sbuf = new StringBuffer();
        currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sbuf.append(helloWorld);
        }
        res = sbuf.toString();
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}
