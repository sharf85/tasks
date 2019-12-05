package com.telran.employee;

public class WageEmployee extends Employee {

    public WageEmployee(int id, String name, String companyName, int basicSalary, int hoursPerMonth) {
        super(id, name, companyName, basicSalary);
        this.hoursPerMonth = hoursPerMonth;
    }

    private static final int MONTHLY_FULL_HOURS = 170;

    int hoursPerMonth;

    public int computeSalary() {
        return basicSalary * hoursPerMonth / MONTHLY_FULL_HOURS;
    }

    @Override
    public String toString() {
        String res = super.toString() +
                ", hoursPerMonth=" + hoursPerMonth;
        return res;
    }
}
