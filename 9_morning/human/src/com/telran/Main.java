package com.telran;

public class Main {

    public static void main(String[] args) {
        Human vasya = new Human();
        vasya.name = "Vasya";
        vasya.age = 20;

        Human petya = new Human("Petya", 25);

        Human nobody = new Human();

        System.out.println(vasya.introduce());
        System.out.println(petya.introduce());
        System.out.println(nobody.introduce());

        System.out.println(Human.getNumberOfHumans());
    }
}
