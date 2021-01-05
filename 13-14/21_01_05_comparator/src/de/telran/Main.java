package de.telran;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Comparator<Human> coronaComparator = new CoronaComparator();

        Human vasya = new Human(true, 170);
        Human petya = new Human(false, 169);
        Human tonya = new Human(true, 25);

        int comparison = coronaComparator.compare(vasya, petya);
        if (comparison < 0) {
            System.out.println("Petya will be vaccinated first");
        } else if (comparison > 0) {
            System.out.println("Vasya will be vaccinated first");
        } else {
            System.out.println("No matter who will be vaccinated first");
        }
        //how to use comparators in Java collections
        List<Human> humans = Arrays.asList(vasya, petya, tonya);

        // straight sort
//        Collections.sort(humans, coronaComparator);// {petya, tonya, vasya}
        humans.sort(coronaComparator);// {petya, tonya, vasya}
        System.out.println(humans.toString());

        // reversed sort
//        Collections.sort(humans, coronaComparator.reversed());// {vasya, tonya, petya}
        humans.sort(coronaComparator.reversed());// {vasya, tonya, petya}
        System.out.println(humans.toString());

    }
}

class Human {
    boolean isMedicalPersonal;
    int age;

    public Human(boolean isMedicalPersonal, int age) {
        this.isMedicalPersonal = isMedicalPersonal;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "isMedicalPersonal=" + isMedicalPersonal +
                ", age=" + age +
                '}';
    }
}

/**
 * The comparator determines a rule for comparing of two humans.
 * The rule is as follows: The most priority has a person who is a medical personal,
 * than the most priority has the one with the higher age.
 */
class CoronaComparator implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        if (h1.isMedicalPersonal && h2.isMedicalPersonal ||
                !h1.isMedicalPersonal && !h2.isMedicalPersonal)
            return h1.age - h2.age;

        if (h1.isMedicalPersonal)
            return 1;
        else
            return -1;
    }
}
