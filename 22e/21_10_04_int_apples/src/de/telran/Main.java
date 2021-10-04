package de.telran;

public class Main {

    final static int SOME_INT_CONSTANT = 15;

    public static void main(String[] args) {
        final int mashaAppleQty = 2;
        final int petyaAppleQty = 4;

        final int totalApples = mashaAppleQty + petyaAppleQty;
        System.out.println("Masha and Petya have " + totalApples + " apples in total");
    }
}
