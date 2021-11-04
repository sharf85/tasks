package de.telran;

public class Main {

    public static void main(String[] args) {

        LoanUser youngUser = new LoanUser("Vasya", "Vasin", 25, 40000);

        LoanIssuer lazyAndKindIssuer = new LoanIssuer("Maria", "Petrovna", true, true);

        System.out.println(lazyAndKindIssuer.toProvide(youngUser));// the result tells whether the issuer provides a loan to the user
    }
}
