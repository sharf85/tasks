package com.telran;

public class Application {

    public static void main(String[] args) {
        Employee masha = new Manager(1, "Masha", "TelRan", 3000, 1.5);
        Employee vasya = new CallCenterEmployee(2, "Vasya", "TelRan", 2500, 100);
        Employee petya = new CallCenterEmployee(3, "Petya", "TelRan", 2500, 220);

        Employee[] employees = new Employee[]{masha, vasya, petya};

        printSalaries(employees);
    }

    private static void printSalaries(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Employee " + employees[i].getName() + " earns " + employees[i].getMonthlySalary());
        }
    }
}
