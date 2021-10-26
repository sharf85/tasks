package de.telran;

public class Main {

    public static void main(String[] args) {
        printCredits(26);
        printCredits(25);
    }

    //    Если номер кредита делится на 13, его никто не выдает. Если номер кредита делится на 3, его выдает Маша.
    //    Если остаток от деления номера кредита равен 1, его выдает Петя. Если 2, то Вася. Вывести в консоль, кто выдал
    //    текущий кредит, а также после всех выданных кредитов вывести их количество. Если известен номер послднего
    //    выданного кредита. static void function(int creditNumber)
    static void printCredits(int lastCreditNumber) {
        if (lastCreditNumber % 13 == 0) {
            System.out.println("The number " + lastCreditNumber + " is impossible to provide");
            return;
        }

        int numberGivenCredits = 0;
        for (int i = 1; i <= lastCreditNumber; i++) {
            if (i % 13 == 0) {
                continue;
            }

            int remainderFrom3 = i % 3;
            if (remainderFrom3 == 0) {
                System.out.println("The credit number " + i + " was provided by Masha");
            } else if (remainderFrom3 == 1) {
                System.out.println("The credit number " + i + " was provided by Petya");
            } else {
                System.out.println("The credit number " + i + " was provided by Vasya");
            }
            numberGivenCredits++;
        }
        System.out.println("The number of all provided credits is " + numberGivenCredits);
    }
}
