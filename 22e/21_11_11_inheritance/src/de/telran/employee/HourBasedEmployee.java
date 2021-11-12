package de.telran.employee;

public class HourBasedEmployee extends Employee {

    int hours;

    public HourBasedEmployee(int id, String name, String companyName, int basicSalary, int hours) {
        super(id, name, companyName, basicSalary);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public int getSalary() {
        return basicSalary * hours / 180;
    }
}
