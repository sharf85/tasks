package com.telran;

public class Application {

    public static void main(String[] args) {
// clone method testing
//
//        Human[] humans1 = {
//                new Human("Vasya", 20),
//                new Human("Petya", 30)
//        };
//
//        Human[] humans2 = humans1.clone();
//        humans1[0].name = "Vasisualiy";
//
//        System.out.println(humans1[0]);
//        System.out.println(humans2[0]);
//
//        humans1[0] = new Human("Masha", 20);
//
//        System.out.println(humans1[0]);
//        System.out.println(humans2[0]);

    }
}

class Human {
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
