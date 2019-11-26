package com.telran;

public class LoanConsumer {

    private String name;
    private int age;
    private int annualSalary;

    public LoanConsumer(String name, int age, int annualSalary) {
        this.name = name;
        this.age = age;
        this.annualSalary = annualSalary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }
}
