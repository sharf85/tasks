package com.telran;

public class Application {

    public static void main(String[] args) {

        LoanIssuer vasya = new LoanIssuer("Vasily", true, true);
        LoanIssuer petya = new LoanIssuer("Petr", false, false);
        LoanIssuer masha = new LoanIssuer("Maria", false, true);

        LoanConsumer youngRichPerson = new LoanConsumer("Jung Rich", 25, 100000);
        LoanConsumer youngPoorPerson = new LoanConsumer("Jung Poor", 25, 10000);
        LoanConsumer adultRichPerson = new LoanConsumer("Adult Rich", 55, 100000);
        LoanConsumer adultPoorPerson = new LoanConsumer("Adult Poor", 55, 10000);
        LoanConsumer oldRichPerson = new LoanConsumer("Old Rich", 75, 100000);
        LoanConsumer oldPoorPerson = new LoanConsumer("Old Poor", 75, 10000);

        LoanIssuer[] workers = {vasya, petya, masha};
        LoanConsumer[] consumers = {
                youngPoorPerson,
                youngRichPerson,
                adultPoorPerson,
                adultRichPerson,
                oldPoorPerson,
                oldRichPerson
        };
    }
}
