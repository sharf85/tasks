package de.telran;

import de.telran.employee.Employee;
import de.telran.employee.HourBasedEmployee;
import de.telran.employee.Manager;
import de.telran.employee.OfficeEmployee;

public class Main {

    //Наследование классов - это способность одного класса наследовать (расширять/extend) функциональность другого класса
    public static void main(String[] args) {
        Employee officeEmployeePetya = new OfficeEmployee(2, "Petya", "Tel-Ran", 2500, 300);
        Employee managerStepan = new Manager(3, "Stepan Stepanovich", "Tel-Ren", 2000, 2.5);
        Employee hourEmployeeTanya = new HourBasedEmployee(4, "Tatiana", "Tel-Ran", 2500, 150);

        System.out.println(officeEmployeePetya.getSalary());
        System.out.println(managerStepan.getSalary());
        System.out.println(hourEmployeeTanya.getSalary());

        Employee[] employees = {officeEmployeePetya, managerStepan, hourEmployeeTanya};

        OfficeEmployee petya = (OfficeEmployee) employees[1];

        for (int i = 0; i < employees.length; i++) {
            System.out.println("The employee " + employees[i].getName() + " has salary " + employees[i].getSalary());
        }
    }
}
