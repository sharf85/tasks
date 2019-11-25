package com.telran;

public class Manager extends Employee {

    private double coefficient;

    public Manager(int id, String name, String companyName, int basicSalary, double coefficient) {
        super(id, name, companyName, basicSalary);
        this.coefficient = coefficient;
    }

    public int getMonthlySalary() {
        return (int) (basicSalary * coefficient);
    }
}
