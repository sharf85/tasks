package de.telran;

public class Main {

    public static void main(String[] args) {

        LoanIssuer vasily = new LoanIssuer("Vasily", true, true);

        LoanConsumer evgeny = new LoanConsumer("Evgeny", 35, 1000);

        if (vasily.toIssue(evgeny)) {
            System.out.println("Employee " + vasily.getName() + " issues a loan to " + evgeny.getName());
        } else {
            System.out.println("Employee " + vasily.getName() + " does not issue a loan to " + evgeny.getName());
        }
    }
}
