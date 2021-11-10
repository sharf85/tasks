package de.telran.employee;

public class OfficeEmployee extends Employee {
    int monthlyBonus;

    public OfficeEmployee(int id, String name, String companyName, int basicSalary, int monthlyBonus) {
        super(id, name, companyName, basicSalary);
        this.monthlyBonus = monthlyBonus;
    }

    public int getMonthlyBonus() {
        return monthlyBonus;
    }

    @Override
    public int getSalary() {
        return basicSalary + monthlyBonus;
    }


}
