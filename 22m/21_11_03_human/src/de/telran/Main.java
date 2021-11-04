package de.telran;

public class Main {

    public static void main(String[] args) {
        // create an instance of the class Human
        Human vasya = new Human("Vasya", "Vasin", 20);

        Human petya = new Human("Petya", "Petin", 25);

        vasya.introduce();
        petya.introduce();

        Human noname = new Human(null, null, 0);
        noname.introduce();

        Cat cat = new Cat();
        cat.mau();
    }
}
