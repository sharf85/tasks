package com.telran;

public class Main {

    public static void main(String[] args) {
        final int petyaOrdered = 4;
        final int mashaOrdered = petyaOrdered / 2;

//        in the very beginning
        int onTheTable = petyaOrdered + mashaOrdered;

//        guys drank by one beer
        int mashaDrank = 1;
        int petyaDrank = 1;

        onTheTable = onTheTable - petyaDrank - mashaDrank;
//        vasya ordered more beer
        final int vasyaOrdered = onTheTable + 1;
//        became on the table after vasya ordered
        onTheTable += vasyaOrdered;

        if (onTheTable % 3 == 0) {
            System.out.println("The beer has been divided");
        } else {
            System.out.println("The beer has not been divided");
        }

        mashaDrank += (onTheTable / 3);

        boolean isMashaHappy = mashaDrank > 4;
        if (isMashaHappy) {
            System.out.println("Masha is funny");
        } else {
            System.out.println("Masha is not funny, as she drank only " + mashaDrank + " beers");
        }

    }
}
