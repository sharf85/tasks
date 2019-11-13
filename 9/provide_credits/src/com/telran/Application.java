package com.telran;

public class Application {

    public static void main(String[] args) {
        CreditUser oldPoorGuy = new CreditUser("Old",
                "Poor",
                80,
                10000);
        CreditUser oldRichGuy = new CreditUser("Old",
                "Rich",
                80,
                100000);
        CreditUser youngPoorGuy = new CreditUser("Young",
                "Poor",
                30,
                10000);
        CreditUser youngRichGuy = new CreditUser("Young",
                "Rich",
                30,
                100000);
        CreditUser maturePoorGuy = new CreditUser("Mature",
                "Poor",
                60,
                10000);
        CreditUser matureRichGuy = new CreditUser("Mature",
                "Rich",
                60,
                100000);

        CreditProvider vasya = new CreditProvider("Vasily",
                "Telranov",
                true,
                true);
        CreditProvider masha = new CreditProvider("Maria",
                "Telranec",
                false,
                true);
        CreditProvider petya = new CreditProvider("Peter",
                "Unnamed",
                false,
                false);

        CreditUser[] users = {oldPoorGuy, oldRichGuy, youngPoorGuy, youngRichGuy, maturePoorGuy, matureRichGuy};
        CreditProvider[] providers = {vasya, masha, petya};


        System.out.println("Vasya works:");
        System.out.println(vasya.name + "'s decision for "
                + youngPoorGuy.name + " "
                + youngPoorGuy.surname + " is " +
                vasya.toProvide(youngPoorGuy));
        System.out.println(vasya.name + "'s decision for "
                + youngRichGuy.name + " "
                + youngRichGuy.surname + " is " +
                vasya.toProvide(youngRichGuy));
        System.out.println(vasya.name + "'s decision for "
                + oldPoorGuy.name + " "
                + oldPoorGuy.surname + " is " +
                vasya.toProvide(oldPoorGuy));
        System.out.println(vasya.name + "'s decision for "
                + oldRichGuy.name + " "
                + oldRichGuy.surname + " is " +
                vasya.toProvide(oldRichGuy));
        System.out.println(vasya.name + "'s decision for "
                + maturePoorGuy.name + " "
                + maturePoorGuy.surname + " is " +
                vasya.toProvide(maturePoorGuy));
        System.out.println(vasya.name + "'s decision for "
                + matureRichGuy.name + " "
                + matureRichGuy.surname + " is " +
                vasya.toProvide(matureRichGuy));

    }
}
