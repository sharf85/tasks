package de.telran;

public class Main {

    public static void main(String[] args) {

        // print out all numbers between 0 and 10
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;

        while (i < 10) {
            System.out.println(i);
            i++;
        }

        // print out all even numbers from 20 down to 0
        for (int j = 20; j >= 0; j -= 2) {
            System.out.println(j);
        }

        // print 10 times the word "Hello"

        for (int j = 0; j < 10; j++) {
            System.out.println("Hello");
        }

    }
}
