package com.telran;

public class VariablesApplication {

    public void main(String[] args, int a) {
    }

    public static void main(String[] args) {
        byte a = 0;
        short b = 5;

        byte c = (byte) (a + b);
        short d = (short) (a + b);

        char aChar = 'a';
        char bChar = 'b';

        System.out.println(aChar + bChar);
        System.out.println("" + aChar + bChar);

        double double1 = 0.1;
        float float1 = 0.6f;
        float float2 = float1 + float1;
        float float3 = (float) double1 + float1;//down-casting

        int int1 = 1_000_000;//1000000
    }
}
