package de.telran;

public class Main {

    public static void main(String[] args) {
        double someDouble = 10.5;
        float someFloat = 13.7f;
        float anotherFloat = 3.4f;

        float resultingFloat = someFloat + anotherFloat;
        double resultingDouble = someFloat + someDouble;

        float floatPlusLong = someFloat + 10L;

        int someInt = 10;
        int anotherInt = 3;

        double divisionResult = someInt / anotherInt;//3.0
        System.out.println(divisionResult);

        //the same
//        int divisionIntResult = someInt / anotherInt;
//        double divisionResult = divisionIntResult;//3.0

        double correctDivisionResult = (double) someInt / anotherInt;//3.3333
        System.out.println(correctDivisionResult);

        System.out.println((int) 111111111111111.5);

        System.out.println((byte) 128);
    }

}
