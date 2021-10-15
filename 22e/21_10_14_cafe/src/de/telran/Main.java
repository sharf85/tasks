package de.telran;

public class Main {

    //Петя, Маша и Вася решили встретиться в кафе. Петя и Маша пришли раньше.
    //Петя заказал 4 куска чизкейка, а Маша в 2 раза меньше.
    //Они съели по куски, и пришел Вася, который тут же заказал столько кусков, сколько лежало на столе + 1.
    //Смогут ли они поделить имеющиеся куски на троих? Будет ли Маша счастлива, если для счастья ей надо не меньше 4х кусков.
    //(Можно сделать в main)
    public static void main(String[] args) {

        final int petyaOrdered = 4;
        final int mashaOrdered = petyaOrdered / 2;
        final int mashaAteBeforeVasyaCame = 1;
        final int petyaAteBeforeVasyaCame = 1;

        final int piesOnTableBeforeVasyaCame = petyaOrdered + mashaOrdered - mashaAteBeforeVasyaCame - petyaAteBeforeVasyaCame;

        final int vasyaOrdered = piesOnTableBeforeVasyaCame + 1;

        final int totalOnTable = piesOnTableBeforeVasyaCame + vasyaOrdered;

        if (totalOnTable % 3 == 0) {
            System.out.println("The pies can be shared by the guys");

            int mashaAteInTotal = mashaAteBeforeVasyaCame + totalOnTable / 3;
            if (mashaAteInTotal >= 4) {
                System.out.println("Masha is happy");
            }
        }
    }
}
