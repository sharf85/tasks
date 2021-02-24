package de.telran.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private String name;
    private String code;
    private List<Employee> employees;

    public Department(String name, String code) {
        this.name = name;
        this.code = code;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeByName(String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }
}
