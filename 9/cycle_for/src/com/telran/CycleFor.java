package com.telran;

public class CycleFor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // equivalent
        int j = 0;
        while (j < 10) {
            System.out.println(j);
            j++;
        }

        int sum = 0;
        for (int i = 1; i < 88; i++) {
            sum += i;
        }
        // the same
        sum = 0;
        for (int i = 87; i > 0; i--) {
            sum += i;
        }
        System.out.println(sum);
    }

}
