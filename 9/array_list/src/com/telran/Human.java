package com.telran;

import java.util.Objects;

class Human {

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;
    int money;

    @Override
    public String toString() {
        return "Human<" +
                "name='" + name + '\'' +
                ", age=" + age +
                '>';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

