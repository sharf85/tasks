package com.telran;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {
    DepartmentService departmentService = new DepartmentService();

    @Test
    void testCountLeaders_caseIT() {
        Employee salesManager1 = new Employee("Petya", 50_000);
        Employee salesManager2 = new Employee("Vasya", 50_000);
        Employee marketingConsultant = new Employee("Andrey", 80_000);
        Employee secretary = new Employee("Lenochka", 40_000);

        Employee programmerJunior = new Employee("Oleg", 40_000);
        Employee programmerMidl1 = new Employee("Viktor", 55_000);
        Employee programmerMidl2 = new Employee("Sergey", 55_000);
        Employee programmerSenior = new Employee("Anna", 70_000);
        Employee itTeamLead = new Employee("Aleksey", 90_000);

        Employee graphicDesigner1 = new Employee("Anton", 50_000);
        Employee graphicDesigner2 = new Employee("Masha", 50_000);
        Employee uxDesigner = new Employee("Denis", 60_000);
        Employee designTeamLead = new Employee("Denis", 80_000);

        List<Employee> salesStuff = List.of(salesManager1, salesManager2, marketingConsultant, secretary);
        List<Employee> programmers = List.of(programmerJunior, programmerMidl1, programmerMidl2, programmerSenior, itTeamLead);
        List<Employee> designers = List.of(graphicDesigner1, graphicDesigner2, uxDesigner, designTeamLead);

        Department sales = new Department("Sales", "s01m01d01y2020", salesStuff);
        Department it = new Department("IT", "it02m01d01y2020", programmers);
        Department design = new Department("Design", "d03m01d01y2020", designers);

        List<Department> departments = List.of(sales, it, design);

        assertEquals(2, departmentService.countEmployeesByDepartmentCodeAndSalaryGreaterThanLimit(departments, 60_000, "it02"));
    }

    @Test
    void testCountLeaders_caseSales() {
        Employee salesManager1 = new Employee("Petya", 50_000);
        Employee salesManager2 = new Employee("Vasya", 50_000);
        Employee marketingConsultant = new Employee("Andrey", 80_000);
        Employee secretary = new Employee("Lenochka", 40_000);

        Employee programmerJunior = new Employee("Oleg", 40_000);
        Employee programmerMidl1 = new Employee("Viktor", 55_000);
        Employee programmerMidl2 = new Employee("Sergey", 55_000);
        Employee programmerSenior = new Employee("Anna", 70_000);
        Employee itTeamLead = new Employee("Aleksey", 90_000);

        Employee graphicDesigner1 = new Employee("Anton", 50_000);
        Employee graphicDesigner2 = new Employee("Masha", 50_000);
        Employee uxDesigner = new Employee("Denis", 60_000);
        Employee designTeamLead = new Employee("Denis", 80_000);

        List<Employee> salesStuff = List.of(salesManager1, salesManager2, marketingConsultant, secretary);
        List<Employee> programmers = List.of(programmerJunior, programmerMidl1, programmerMidl2, programmerSenior, itTeamLead);
        List<Employee> designers = List.of(graphicDesigner1, graphicDesigner2, uxDesigner, designTeamLead);

        Department sales = new Department("Sales", "s01m01d01y2020", salesStuff);
        Department it = new Department("IT", "it02m01d01y2020", programmers);
        Department design = new Department("Design", "d03m01d01y2020", designers);

        List<Department> departments = List.of(sales, it, design);

        assertEquals(1, departmentService.countEmployeesByDepartmentCodeAndSalaryGreaterThanLimit(departments, 60_000, "s01"));
    }

    @Test
    void testCountLeaders_caseDesign() {
        Employee salesManager1 = new Employee("Petya", 50_000);
        Employee salesManager2 = new Employee("Vasya", 50_000);
        Employee marketingConsultant = new Employee("Andrey", 80_000);
        Employee secretary = new Employee("Lenochka", 40_000);

        Employee programmerJunior = new Employee("Oleg", 40_000);
        Employee programmerMidl1 = new Employee("Viktor", 55_000);
        Employee programmerMidl2 = new Employee("Sergey", 55_000);
        Employee programmerSenior = new Employee("Anna", 70_000);
        Employee itTeamLead = new Employee("Aleksey", 90_000);

        Employee graphicDesigner1 = new Employee("Anton", 50_000);
        Employee graphicDesigner2 = new Employee("Masha", 50_000);
        Employee uxDesigner = new Employee("Denis", 60_000);
        Employee designTeamLead = new Employee("Denis", 80_000);

        List<Employee> salesStuff = List.of(salesManager1, salesManager2, marketingConsultant, secretary);
        List<Employee> programmers = List.of(programmerJunior, programmerMidl1, programmerMidl2, programmerSenior, itTeamLead);
        List<Employee> designers = List.of(graphicDesigner1, graphicDesigner2, uxDesigner, designTeamLead);

        Department sales = new Department("Sales", "s01m01d01y2020", salesStuff);
        Department it = new Department("IT", "it02m01d01y2020", programmers);
        Department design = new Department("Design", "d03m01d01y2020", designers);

        List<Department> departments = List.of(sales, it, design);

        assertEquals(2, departmentService.countEmployeesByDepartmentCodeAndSalaryGreaterThanLimit(departments, 60_000, "d03"));
    }
}
