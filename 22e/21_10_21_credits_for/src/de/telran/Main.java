package de.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(countCredits(2));
    }

    static int countCredits(int monthNumber) {
        int vasyaPerMonth = 50;
        int petyaPerMonth = 40;
        int mashaPerMonth = 50;

        int res = 0;
        for (int i = 1; i <= monthNumber; i++) {
            res += vasyaPerMonth + petyaPerMonth + mashaPerMonth;
            mashaPerMonth++;

            if (i % 2 == 0)
                petyaPerMonth++;

            if (i < 10)
                vasyaPerMonth--;
            else
                vasyaPerMonth = 50;
        }

        return res;
    }
}
