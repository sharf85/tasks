package de.telran;

import de.telran.human.Human;

public class Main {

    public static void main(String[] args) {
        Human vasya = new Human("Vasya", "Vasin", 20);
        vasya.introduce();
        System.out.println(vasya.getName());

        Human petya = new Human("Petya", "Petin", 22);
        petya.introduce();
        System.out.println(petya.getSurname());

        System.out.println(Human.getHumanNumber());

        petya.die();

        System.out.println(Human.getHumanNumber());

        petya.introduce();
    }
}
