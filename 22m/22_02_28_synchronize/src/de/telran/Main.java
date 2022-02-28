package de.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        IntegerWrapper wrapper = new IntegerWrapper();
        IntegerWrapper wrapper2 = new IntegerWrapper();

        Incrementer incrementer1 = new Incrementer(wrapper, 10000000);
        Incrementer incrementer2 = new Incrementer(wrapper, 10000000);
        Incrementer incrementer3 = new Incrementer(wrapper2, 10000000);
        Incrementer incrementer4 = new Incrementer(wrapper2, 10000000);

        Thread thread1 = new Thread(incrementer1);
        Thread thread2 = new Thread(incrementer2);
        Thread thread3 = new Thread(incrementer3);
        Thread thread4 = new Thread(incrementer4);

        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(System.currentTimeMillis() - startTime);

        System.out.println(wrapper.getNumber());
        System.out.println(wrapper2.getNumber());
    }
}
