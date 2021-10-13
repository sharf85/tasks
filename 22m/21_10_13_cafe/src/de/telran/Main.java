package de.telran;

public class Main {

    //Маша, Петя и Вася договорились встретиться в кафе. Маша и Петя пришли раньше.
    //Петя сразу заказал 4 куска чизкейка, а Маша в два раза меньше.
    //Они съели по одному куску, после чего пришел Вася и заказал еще столько кусков, сколько лежало на столе + 1.
    //Поделят ли они имеющиеся на столе чизкейки на троих? Будет ли Маша счастлива, если ей для счастья надо съесть не меньше 4х кусков? Сделать прямо в методе main.
    public static void main(String[] args) {

        int petyaOrderd = 4;
        int mashaOrderd = petyaOrderd / 2;
        int mashaAte = 1;
        int petyaAte = 1;

        int restOnTableWhenVasyaCame = petyaOrderd + mashaOrderd - petyaAte - mashaAte;
        int vasyaOrdered = restOnTableWhenVasyaCame + 1;
        int piecesOnTable = restOnTableWhenVasyaCame + vasyaOrdered;

        if (piecesOnTable % 3 == 0) {
            System.out.println("The cheesecake pieces can be shared among the guys");
            int mashaAteTotal = piecesOnTable / 3 + mashaAte;
            if (mashaAteTotal >= 4) {
                System.out.println("Masha got happy");
            } else {
                System.out.println("Masha remained unhappy");
            }
        }

    }


}
