package com.telran;

public class SymbolPrinter implements Runnable {

    private int n;
    private char symbol;

    public SymbolPrinter(int n, char symbol) {
        this.n = n;
        this.symbol = symbol;
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

        System.out.println("End of printer " + symbol);
    }
}
