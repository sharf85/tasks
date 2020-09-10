package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

    String name;
    String code;
    List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = new ArrayList<>(employees);
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
}
