package com.telran.server_app.dto;

import java.util.List;

//Data transfer object
public class JsonHelloDTO {
    public String name;
    public int age;
    public List<CourseDTO> courses;

    public JsonHelloDTO(String name, int age, List<CourseDTO> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }
}
