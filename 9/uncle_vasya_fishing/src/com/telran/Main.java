package com.telran;

public class Main {

    public static void main(String[] args) {
        int dayOfWeek = 4;
        int temp = 20;

        if (dayOfWeek == 4 && temp >= 19 && temp <= 23) {
            System.out.println("Vasily goes fishing");
        } else if (dayOfWeek < 4) {
            System.out.println((4 - dayOfWeek) + " days remain before fishing");
        } else if (dayOfWeek > 4) {
            System.out.println((7 - dayOfWeek + 4)
                    + " days remains before fishing");
        } else if (temp < 19) {
            System.out.println("It's too cold to go fishing");
        } else {
            System.out.println("it's too hot to go fishing");
        }
    }
}
