package com.telran.employee;

public abstract class Employee {
    public Employee(int id, String name, String companyName, int basicSalary) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.basicSalary = basicSalary;
    }

    private int id;
    String name;
    String companyName;
    int basicSalary;

    public abstract int computeSalary();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", basicSalary=" + basicSalary
                ;
    }
}
