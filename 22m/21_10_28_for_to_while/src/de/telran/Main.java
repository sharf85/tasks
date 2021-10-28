package de.telran;

public class Main {

    public static void main(String[] args) {

        int n = 10;

        for (int i = 0; i < 10; i++) {
            System.out.println("Under for " + i);
        }

        int counter = 0;
        while (counter < 10) {

            for (int counterFor = 0; counterFor < 5; counterFor++) {
                System.out.println("inside");
            }

            System.out.println("Outside");
            counter += 2;
        }

        int[] someArray = new int[]{5, 3, 12, -10, 5};

        someArray[4] = 6;//{5, 3, 12, -10, 6}
        int counter2 = 0;
        while (counter2 < someArray.length) {
            System.out.print(someArray[counter2] + " ");
            counter2 += 1;
        }

    }
}
