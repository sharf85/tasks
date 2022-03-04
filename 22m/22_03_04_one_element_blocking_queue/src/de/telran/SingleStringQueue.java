package de.telran;

public class SingleStringQueue {
    private String line;

    public void add(String line) {
        this.line = line;
        synchronized (this) {
            this.notify();
        }
    }

    public String remove() throws InterruptedException {
        synchronized (this) {
            while (line == null) {
                this.wait();
            }
            String res = line;
            line = null;
            return res;
        }
    }
}
