package com.cool_telran;

public class TotalCheesecake {

    public static void main(String[] args) {
        double mashaPart = 1d / 3;
        double peterPart = mashaPart / 2;
        double vasyaPart = (mashaPart + peterPart) * 4;

        int totalIntCheesecake = (int) (mashaPart + peterPart + vasyaPart);
        System.out.println(totalIntCheesecake);
    }
}
