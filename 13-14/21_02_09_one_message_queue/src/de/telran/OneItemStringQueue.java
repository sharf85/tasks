package de.telran;

public class OneItemStringQueue {

    private final Object mutex = new Object();

    private String source;

    public void addFirst(String item) {
        source = item;

        // wake
        mutex.notify();
    }

    public String removeLast() throws InterruptedException {
        synchronized (mutex) {
            while (source == null)
                //sleep
                mutex.wait();
        }

        String res = source;
        source = null;
        return res;
    }
}
