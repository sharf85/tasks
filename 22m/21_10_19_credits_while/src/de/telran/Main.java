package de.telran;

public class Main {

    public static void main(String[] args) {

        //Маша выдает в месяц 50 кредитов. Петя выдает в месяц 0.8 от Маши. Василий выдает 0.5 от Маши,
        //пока они все вместе не выдадут 1370 кредитов, затем начинает работать с Машиной скоростью.
        //Сколько месяцев надо, чтобы выдать 2100 кредитов.
        //(Решить, испльзуя while)

        final int mashaVelocity = 50;
        final int petyaVelocity = mashaVelocity * 8 / 10;
        final int lazyVasyaVelocity = mashaVelocity / 2;
        final int motivatedVasyaVelocity = mashaVelocity;

        int sumCredits = 0;
        int monthNumber = 0;

        while (sumCredits < 2100) {
            if (sumCredits < 1370) {
//                sumCredits += mashaVelocity + petyaVelocity + lazyVasyaVelocity;
                sumCredits = sumCredits + mashaVelocity + petyaVelocity + lazyVasyaVelocity;
            } else {
                sumCredits += mashaVelocity + petyaVelocity + motivatedVasyaVelocity;
            }
            monthNumber++;
        }
        System.out.println(monthNumber);
        System.out.println(sumCredits);
    }
}
