package de.telran;

public class Main {

    public static void main(String[] args) {
        int a;//declaration
        a = 5;//initialisation // 5
        int b = 10;

        System.out.println(a);
        a = 18;// 18
        System.out.println(a);

        byte someByte;//

        someByte = 17;

        int sum = someByte + someByte;//upcasting

        short someShort = 15;

        int mul = someShort * someByte;//upcasting

        long someLong = 56;

        long anotherLong = someLong + someShort;

        //+-* - everything clear
        //division
        long divided = someLong / someShort;//3
        System.out.println(divided);
        // %
        long remainder = someLong % someShort;
        System.out.println(remainder);

        System.out.println(-10 % 3);

        // down-casting
        int intFromSomeLong = (int) someLong;
        // up-casting
        someLong = someByte;
    }
}
