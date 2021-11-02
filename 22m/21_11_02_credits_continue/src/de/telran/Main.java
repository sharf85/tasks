package de.telran;

public class Main {

    public static void main(String[] args) {
        issueLoans(13);
        issueLoans(30);
        issueLoans(25);

    }

    //Если номер кредита делится на 13, то его никто не выдает. Если он делится на 3, то его выдает Маша.
    //Если номер кредита имеет остаток 1 от деления на 3, то Петя, если 2 - то Вася.
    //Написать функцию, которая принимает номер последнего выданного кредита и распечатывает в консоль информацию о том,
    //кто выдал какой кредит и еще количество выданных кредитов после этого. static void function(int creditId)
    static void issueLoans(int lastCreditNumber) {
        if (lastCreditNumber % 13 == 0) {
            System.out.println("The loan with such a number cannot exist, as it is divided by 13");
            return;
        }

        int totalCreditsIssued = 0;
        for (int i = 1; i <= lastCreditNumber; i++) {
            if (i % 13 == 0) {
                System.out.println("The loan with number " + i + " was not issued");
                continue;
            }

            totalCreditsIssued++;
            int remainderBy3 = i % 3;

            if (remainderBy3 == 0) {
                System.out.println("The loan number " + i + " was issued by Masha");
            } else if (remainderBy3 == 1) {
                System.out.println("The loan number " + i + " was issued by Petya");
            } else {
                System.out.println("The loan number " + i + " was issued by Vasya");
            }
        }

        System.out.println("The number of loans issued in total is: " + totalCreditsIssued);
    }
}
