package de.telran;

public class Main {

    public static void main(String[] args) {

        int a = 5;

        a = a + 14;//19
//        a += 14;//equivalent
        a = a * 8;//a *= 8
        a = a - 8;//a -= 8
        a = a / 8;//a /= 8
        a = a % 8;//a %= 8

        a = a + 1;// a += 1; a++, ++a

        // print out all numbers from 1 to 10

        int number = 1;
        while (number <= 10) {
            System.out.print(number + " ");
            number++;// number = number + 1;
        }
        System.out.println();

        // print out all even numbers from 20 down to 0

        number = 20;
        while (number >= 0) {
            System.out.println(number + " ");
            number -= 2;
        }

        // the same but slower
//        number = 20;
//        while (number >= 0) {
//            if (number % 2 == 0) {
//                System.out.println(number);
//            }
//            number--;
//        }

        // count the sum of numbers from 1 to 87

        number = 1;
        int sum = 0;

        while (number <= 87) {
            sum = sum + number;
            number++;
        }

        System.out.println(sum);

    }
}
