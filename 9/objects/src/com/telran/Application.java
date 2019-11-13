package com.telran;

public class Application {

    public static void main(String[] args) {
        System.out.println(Human.numberOfHumans);
        Human vasya = new Human();
        Human vasyaClone = vasya;
        vasya.name = "Vasily";
        vasya.surname = "Telranov";
        vasya.age = 2;

        System.out.println(vasyaClone.name);//Vasily

        vasya.introduce();
        System.out.println(Human.numberOfHumans);

        Human petya = new Human("Petr", "Telranstein", 2);
        petya.introduce();

        System.out.println(Human.numberOfHumans);
        System.out.println(vasya.numberOfHumans);
        System.out.println(petya.numberOfHumans);
    }
}

