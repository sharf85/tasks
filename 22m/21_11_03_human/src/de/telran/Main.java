package de.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // create an instance of the class Human
        Human vasya = new Human("Vasya", "Vasin", 20);

        Human petya = new Human("Petya", "Petin", 25);

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


        int[] array = {234, 3, 23, 343};

        Arrays.sort(array);
    }
}
