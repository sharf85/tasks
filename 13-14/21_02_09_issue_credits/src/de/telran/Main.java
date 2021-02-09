package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int CREDITS_NUM = 20;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> workers = new ArrayList<>();
        List<Score> result = new ArrayList<>();

        workers.add(new Thread(new Issuer("Tanya", 100, 200, CREDITS_NUM, result)));
        workers.add(new Thread(new Issuer("Petya", 200, 300, CREDITS_NUM, result)));
        workers.add(new Thread(new CreativeIssuer("Vasya", 200, 300, CREDITS_NUM, result, 50, 100, 3, 25)));

        for (Thread worker : workers)
            worker.start();

        for (Thread worker : workers)
            worker.join();

        for (Score speed : result) {
            System.out.println(speed.getName() + " : " + speed.getResult());
        }
    }
}
