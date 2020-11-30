package de.telran;

public class LoanConsumer {

    private String name;
    private int age;
    private int annualIncome;

    public LoanConsumer(String name, int age, int annualIncome) {
        this.name = name;
        this.age = age;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }
}
