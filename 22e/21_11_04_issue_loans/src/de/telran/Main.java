package de.telran;

public class Main {

    public static void main(String[] args) {
        LoanUser vasya = new LoanUser("Vasya", "Vasin", 20, 30000);
        LoanUser petya = new LoanUser("Petya", "Petin", 21, 15000);
        LoanUser masha = new LoanUser("Maria Petrovna", "Ivanova", 55, 40000);
        LoanUser semen = new LoanUser("Semen Semenych", "Semenov", 75, 40000);

        LoanUser[] users = new LoanUser[]{vasya, petya, masha, semen};

        LoanIssuer johan = new LoanIssuer("Johan", "Kruff", true, true);
        LoanIssuer lazyKindClerk = johan;

        LoanIssuer stepan = new LoanIssuer("Stepan", "Strong", false, true);
        LoanIssuer kostik = new LoanIssuer("Konstantin", "Konstantinov", false, false);

        LoanIssuer[] clerks = {johan, stepan, kostik};
        System.out.println(johan.toProvide(vasya));//true
        System.out.println(johan.toProvide(petya));//false

        for (int i = 0; i < clerks.length; i++) {
            for (int j = 0; j < users.length; j++) {
                boolean isProvided = clerks[i].toProvide(users[j]);
                if (isProvided)
                    System.out.println("The clerk " + clerks[i].name + " " + clerks[i].surname + " provides a loan to the user "
                            + users[j].name + " " + users[j].surname);
                else
                    System.out.println("The clerk " + clerks[i].name + " " + clerks[i].surname + " does not provide a loan to the user "
                            + users[j].name + " " + users[j].surname);
            }
        }
    }
}
