package de.telran.employee;

public class Manager extends Employee {

    double coef;

    public Manager(int id, String name, String companyName, int basicSalary, double coef) {
        super(id, name, companyName, basicSalary);
        this.coef = coef;
    }

    public double getCoef() {
        return coef;
    }

    @Override
    public int getSalary() {
        return (int) (basicSalary * coef);
    }
}
