package com.telran;

public class LinePrinter extends Thread {

    private String line;

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(line);
            }
        }
    }
}
