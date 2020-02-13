package com.telran;

public class CharPrinter implements Runnable {

    private char symbol;
    private int n;

    public CharPrinter(char symbol, int n) {
        this.symbol = symbol;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(symbol);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end of CharPrinter");
    }
}
