package de.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // create an instance of the class Human
        Human vasya = new Human("Vasya", "Vasin", 20);

        Human petya = new Human("Petya", "Petin", 25);

        Human masha = new Human("Maria", "Petrovna", 23, "maria.petrovna@gmail.com");

        vasya.introduce();
        petya.introduce();

        System.out.println(vasya.getName());
        System.out.println(vasya.getSurname());
        System.out.println(vasya.getAge());

        System.out.println(Human.getHumanNumber());//2
        System.out.println(Human.getAverageAge());//22

        Cat cat = new Cat();
        cat.mau();

        petya.die();
        System.out.println(Human.getHumanNumber());//1
        System.out.println(Human.getAverageAge());//20

        vasya.setEmail("vasya.vasin@gmail.com");

        System.out.println(vasya.getEmail());
        System.out.println(masha.getEmail());
        System.out.println(petya.getEmail());

    }
}
