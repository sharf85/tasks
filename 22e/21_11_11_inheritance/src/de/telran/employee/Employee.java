package de.telran.employee;

public class Employee {

    int id;
    String name;
    String companyName;
    protected int basicSalary;

    public Employee(int id, String name, String companyName, int basicSalary) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.basicSalary = basicSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public int getSalary() {
        return basicSalary;
    }

}
