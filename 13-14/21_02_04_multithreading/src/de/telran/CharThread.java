package de.telran;

public class CharThread extends Thread {

    final int times;
    final char ch;

    public CharThread(int times, char ch) {
        this.times = times;
        this.ch = ch;
    }

    @Override
    public void run() {
        System.out.println("Start CharThread");
        for (int i = 0; i < times; i++) {
            System.out.println(ch);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
