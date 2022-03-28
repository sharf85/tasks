package de.telran.department;

public class Employee {
    String name;
    long Salary;

    public Employee(String name, long salary) {
        this.name = name;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }
}
