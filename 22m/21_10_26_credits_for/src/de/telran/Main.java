package de.telran;

public class Main {

    public static void main(String[] args) {

        System.out.println(countProvidedCredits(18));
    }

    //Маша выдает 50 кредитов в месяц, каждый месяц улучшая производительность на 1 шт.
    //Петя - 40 в месяц, улучшая производительность каждые 2 месяца на 1.
    //Вася первые 10 месяцев работает 50 кредитов в месяц, каждый месяц ухудшая производительность на 1 шт,
    //но потом берет себя в руки, работая стабильно по 50 кредитов в месяц. Сколько они сделают за полтора года.
    static int countProvidedCredits(int monthNumber) {
        int mashaPerformance = 50;
        int petyaPerformance = 40;
        int vasyaPerformance = 50;

        int res = 0;
        for (int i = 1; i <= monthNumber; i++) {
            res += mashaPerformance + petyaPerformance + vasyaPerformance;

            mashaPerformance++;
            if (i % 2 == 0)
                petyaPerformance++;

            if (i < 10) {
                vasyaPerformance--;
            } else {
                vasyaPerformance = 50;
            }
        }
        return res;
    }
}
