package de.telran;

public class Main {

    public static void main(String[] args) {
        String helloWorld = "Hello world";

        String res = "";

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            res += helloWorld;
        }
        long delta = System.currentTimeMillis() - currentTime;

        System.out.println(delta);

        StringBuilder sb = new StringBuilder();

        currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(helloWorld);
        }
        res = sb.toString();
        delta = System.currentTimeMillis() - currentTime;

        System.out.println(delta);
    }
}
