package com.telran;

public class CallCenterEmployee extends Employee {
    private int monthlyHours;

    private final static int FULL_MONTHLY_HOURS = 176;

    public CallCenterEmployee(int id, String name, String companyName, int basicSalary, int monthlyHours) {
        super(id, name, companyName, basicSalary);
        this.monthlyHours = monthlyHours;
    }

    public int getMonthlySalary() {
        return basicSalary * monthlyHours / FULL_MONTHLY_HOURS;
    }
}
