package com.telran;

public class Main {

    public static void main(String[] args) {
        // if a < 0 then sout "the number is less than 0", otherwise sout "the number is greater or equal to 0"

        int a = 10;
//      I
        if (a < 0) {
            System.out.println("the number is less than 0");
        } else {
            System.out.println("the number is greater or equal to 0");
        }

//      II
        if (a >= 0) {
            System.out.println("the number is greater or equal to 0");
        } else {
            System.out.println("the number is less than 0");
        }

//      III
        boolean isALess0 = a < 0;
        if (isALess0) {
            System.out.println("the number is less than 0");
        } else {
            System.out.println("the number is greater or equal to 0");
        }

// b from double;  b<0; a from [0; 1) - means b>=0 and b<1 ; b>=1

        double b = 0.5;
        if (a < 0) {
            System.out.println("the number is less than 0");
        } else if (a >= 0 && a < 1) {
            System.out.println("the number is greater or equal to 0 and less than 1");
        } else {
            System.out.println("the number is greater or equal to 1");
        }
    }
}
