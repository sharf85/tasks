package de.telran;

public class Main {

    public static void main(String[] args) {
        LoanUser vasya = new LoanUser("Vasya", "Vasin", 20, 30000);

        LoanIssuer lazyKindIssuer = new LoanIssuer("Johan", "Kruff", true, true);

        System.out.println(lazyKindIssuer.toProvide(vasya));
    }
}
