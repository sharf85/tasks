package de.telran;

public class Main {

    public static void main(String[] args) {
        boolean bool1 = false;
        boolean bool2 = true;

        // boolean operations & - and, | - or, ! - negation, ^ - xor

        // & - and
        bool1 = true;
        bool2 = true;
        System.out.println(bool1 & bool2);//true

        bool1 = true;
        bool2 = false;
        System.out.println(bool1 & bool2);//false

        bool1 = false;
        bool2 = true;
        System.out.println(bool1 & bool2);//false

        bool1 = false;
        bool2 = false;
        System.out.println(bool1 & bool2);//false

        // | - or
        bool1 = true;
        bool2 = true;
        System.out.println(bool1 | bool2);//true

        bool1 = true;
        bool2 = false;
        System.out.println(bool1 | bool2);//true

        bool1 = false;
        bool2 = true;
        System.out.println(bool1 | bool2);//true

        bool1 = false;
        bool2 = false;
        System.out.println(bool1 | bool2);//false

        // ^ - xor
        bool1 = true;
        bool2 = true;
        System.out.println(bool1 ^ bool2);//false

        bool1 = true;
        bool2 = false;
        System.out.println(bool1 ^ bool2);//true

        bool1 = false;
        bool2 = true;
        System.out.println(bool1 ^ bool2);//true

        bool1 = false;
        bool2 = false;
        System.out.println(bool1 ^ bool2);//false

        // ! - negation
        bool1 = true;
        System.out.println(!bool1);//false

        bool1 = false;
        System.out.println(!bool1);//true

        // comparison operators (операторы сравнения) <, <=, >, >=, ==, != - operators transforming two numbers into boolean
        int a = 1;
        boolean isAPositive = a > 0;
    }

}
