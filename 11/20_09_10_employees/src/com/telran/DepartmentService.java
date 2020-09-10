package com.telran;

import java.util.List;

public class DepartmentService {

    public int countEmployeesByDepartmentCodeAndSalaryGreaterThanLimit(List<Department> departments, long limit, String prefix) {
        return (int) departments.stream()
                .filter(department -> department.getCode().startsWith(prefix))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= limit)
                .count();
    }
}
