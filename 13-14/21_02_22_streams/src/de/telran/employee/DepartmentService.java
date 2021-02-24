package de.telran.employee;

import java.util.List;

public class DepartmentService {
    public int countEmployeesByDepartmentCodeWithSalaryGreaterThan(List<Department> departments,
                                                                   String code,
                                                                   long threshold) {
        return (int) departments.stream()
                .filter(department -> department.getCode().startsWith(code))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }
}
