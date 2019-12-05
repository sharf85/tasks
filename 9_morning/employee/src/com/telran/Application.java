package com.telran;

import com.telran.employee.Employee;
import com.telran.employee.WageEmployee;

public class Application {

    public static void main(String[] args) {
        Employee vasya = new WageEmployee(1, "Vasya", "TelRan", 1500, 100);
        String s = "Hello " + vasya;
//        String s = "Hello " + vasya.toString();
        System.out.println(s);

    }
}
