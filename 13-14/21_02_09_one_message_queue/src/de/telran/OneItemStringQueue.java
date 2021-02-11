package de.telran;

public class OneItemStringQueue {

    private final Object mutex = new Object();

    private String source;

    public void addFirst(String item) {
        synchronized (mutex) {
            source = item;
            mutex.notify();
        }
    }

    public String removeLast() throws InterruptedException {
        synchronized (mutex) {
            while (source == null) {
                System.out.println("The thread with id " + Thread.currentThread().getId() + " fell asleep");
                mutex.wait();
            }
        }

        String res = source;
        source = null;
        System.out.println("The thread with id " + Thread.currentThread().getId() + " woke up");
        return res;
    }
}
