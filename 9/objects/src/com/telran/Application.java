package com.telran;

public class Application {

    public static void main(String[] args) {
        System.out.println(Human.numberOfHumans);
        Human vasya = new Human();
        vasya.name = "Vasily";
        vasya.surname = "";
        vasya.age = 2;

        vasya.introduce();
        System.out.println(Human.numberOfHumans);

        Human petya = new Human("Petr", "Telranstein", 2);
        petya.introduce();
        System.out.println(Human.numberOfHumans);
    }
}

