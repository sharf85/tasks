package com.telran;

import com.telran.collection.OurArrayList;

import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        OurArrayList list = makeHumanList();

        Human anotherPetya = new Human("Petya", 20);
        list.remove(anotherPetya);

        System.out.println(anotherPetya);
        System.out.println(anotherPetya.toString());
    }

    static OurArrayList makeHumanList() {
        Human vasya = new Human("Vasya", 20);
        Human petya = new Human("Petya", 20);
        Human masha = new Human("Masha", 20);

        OurArrayList res = new OurArrayList();
        res.add(vasya);
        res.add(petya);
        res.add(masha);
        return res;
    }

}

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
//        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
