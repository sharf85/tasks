package de.telran;

import de.telran.employee.Employee;
import de.telran.employee.HourBasedEmployee;
import de.telran.employee.Manager;
import de.telran.employee.OfficeEmployee;

public class Main {

    public static void main(String[] args) {
        Employee officeEmployeePetya = new OfficeEmployee(2, "Petya", "Tel-Ran", 2500, 300);
        Employee managerStepan = new Manager(3, "Stepan Stepanovich", "Tel-Ren", 2000, 2.5);
        Employee hourEmployeeTanya = new HourBasedEmployee(4, "Tatiana", "Tel-Ran", 2500, 150);

        printSalary(officeEmployeePetya);
        printSalary(managerStepan);
        printSalary(hourEmployeeTanya);

        OfficeEmployee officeEmployee = (OfficeEmployee) officeEmployeePetya;
        OfficeEmployee officeEmployeeStepan = (OfficeEmployee) managerStepan;
        System.out.println(officeEmployee.getMonthlyBonus());
        System.out.println(officeEmployeeStepan.getMonthlyBonus());
    }

    public static void printSalary(Employee employee) {
        System.out.println("The employee " + employee.getName() + " earns " + employee.getSalary());
    }
}
