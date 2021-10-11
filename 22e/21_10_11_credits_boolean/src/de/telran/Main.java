package de.telran;

public class Main {
    /*Имеется банк. Маша, Петя и Вася выдают кредиты в нем. Маша выдает один кредит за 1 час.
     Петя работает со скоростью, составляющей 0.8 от скорости Маши. А Вася работает обычно в два раза медленнее Маши,
      но когда замотивирован, то с такой же скоростью. Известно, что Василий становится замотивированным,
      если 80% от плана работники выполнили. Выполнили ли работники план, если тот составляет 1150 кредитов,
      а Маша выдала 490 из них. (Написать ф-ю, которая принимает аргументом число кредитов в плане и число выданных
       Машей кредитов, а возвращает boolean)*/
    public static void main(String[] args) {
        System.out.println(isPlanCompleted(1150, 490));
        System.out.println(isPlanCompleted(1150, 482));
    }

    static boolean isPlanCompleted(int totalInPlan, int mashaMade) {
        final double mashaV = 1;
        final double petyaV = mashaV * 0.8;
        final double nonMotivatedVasyaV = mashaV * 0.5;
        final double motivatedVasyaV = mashaV;

        final double totalFirstPackV = mashaV + petyaV + nonMotivatedVasyaV;
        final double totalSecondPackV = mashaV + petyaV + motivatedVasyaV;

        final int firstCreditsPack = totalInPlan * 8 / 10;
        final int secondCreditsPack = totalInPlan - firstCreditsPack;

        final int firstPackMashaMade = (int) (firstCreditsPack / totalFirstPackV);
        final int secondPackMashaMade = (int) (secondCreditsPack / totalSecondPackV);

        return mashaMade >= firstPackMashaMade + secondPackMashaMade;
    }
}
