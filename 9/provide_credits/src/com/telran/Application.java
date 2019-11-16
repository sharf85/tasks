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

        for (int i = 0; i < providers.length; i++) {
            System.out.println(providers[i].getName() + " " + providers[i].getSurname() + " works:");
            for (int j = 0; j < users.length; j++) {
                System.out.println(providers[i].getName() + "'s decision for "
                        + users[j].name + " "
                        + users[j].surname + " is " +
                        providers[i].toProvide(users[j]));
            }
        }

    }
}
