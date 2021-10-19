package de.telran;

public class Main {

    public static void main(String[] args) {

        // print numbers from 0 to 9
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        {
            int i = 0;
            while (i < 10) {
                System.out.print(i + " ");
                i++;
            }
        }

        System.out.println();

        for (int j = 0; j < 10; j++) {
            System.out.println("Hello");
        }

        // print all even numbers from 20 down to 0
        for (int i = 20; i >= 0; i = i - 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
