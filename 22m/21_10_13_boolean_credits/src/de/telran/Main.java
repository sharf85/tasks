package de.telran;

public class Main {

    //* Имеется банк. Маша выдает 1 кредит в час. Петя работает 0.8 от скорости Маши.
    //Вася, обычно, работает со скоростью, в два раза меньшей, чем работает Маша, но когда замотивирован, то с такой же скоростью.
    //Известно, что Вася становится мотивированным, если 80% от плана выполнено.
    //Выполнили ли работники план, если он состовляет 1150 кредитов, и известно, что Маша выдала 490 кредитов.
    //Написать функцию, которая принимает количество крежитов в плане и количество кредитов, выданных Машей.
    public static void main(String[] args) {
        // write your code here
    }

    static boolean isPlanPerformed(int creditsInPlan, int mashaMade) {
        double mashaVelocity = 1;
        double petyaVelocity = 0.8 * mashaVelocity;
        double unmotivatedVasyaVelocity = mashaVelocity / 2;
        double motivatedVasyaVelocity = mashaVelocity;

        double totalVelocityFirstCreditPack = mashaVelocity + petyaVelocity + unmotivatedVasyaVelocity;
        double totalVelocitySecondCreditPack = mashaVelocity + petyaVelocity + motivatedVasyaVelocity;

        //here vasya is not motivated
        int firstCreditPack = creditsInPlan * 8 / 10;
        int secondCreditPack = creditsInPlan - firstCreditPack;

        int firstPackSpentTime = (int) (firstCreditPack / totalVelocityFirstCreditPack);
        int secondPackSpentTime = (int) (firstCreditPack / totalVelocitySecondCreditPack);

        int mashaPartInPlan = (int) ((firstPackSpentTime + secondPackSpentTime) * mashaVelocity);
        return mashaMade > mashaPartInPlan;
    }
}
