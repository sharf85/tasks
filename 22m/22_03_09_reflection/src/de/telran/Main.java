package de.telran;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // create an instance of a class by its name
        String type = "de.telran.animal.Cat";

        // method forName("de.telran.animal.Fish") returns the object Fish.class
        Class classFromString = Class.forName(type);
        Animal animal = (Animal) classFromString.getConstructor().newInstance();

        System.out.println(animal.sound());
    }
}
