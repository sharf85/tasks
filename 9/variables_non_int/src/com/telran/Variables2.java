package com.telran;

public class Variables2 {

    public static void main(String[] args) {
// The problem of the total amount of Anna's and Peter's apples
        double annaApples = 2.5;
        double peterApples = 3.5;

        double totalApples = annaApples + peterApples;
        System.out.println(totalApples);

        float floatNum1 = 0.4f;
        float floatNum2 = 0.5f;
        float floatsSum = floatNum1 + floatNum2;

        float floatNum3 = 1.9f;
        double doubleNum1 = 1.2;

//        floatNum3 -> double
        double doubleNum2 = floatNum3 + doubleNum1;
//        down casting
//        float test = floatNum3 + (float)doubleNum1;
//        float test = (float)doubleNum1;
        doubleNum2++;
//        double/double
        System.out.println(9.5 / 3.5);
//        float/float
        System.out.println(9.5f / 3.5f);
//        double/float
        System.out.println(9.5 / 3.5f);
//        double/int
        System.out.println(9.5 / 3);
//        double/int
        System.out.println(9.0 / 3);


//        double%double
        System.out.println(9.5 % 3.5);
//        float%float
        System.out.println(9.5f % 3.5f);
//        double%float
        System.out.println(9.5 % 3.5f);
//        double%int
        System.out.println(9.5 % 3);
//        double%int
        System.out.println(9.0 % 3);

        System.out.println(0b1001);

    }
}
