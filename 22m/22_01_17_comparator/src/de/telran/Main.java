package de.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Компаратор это паттерн программирования, олицетворяющий правило, по которому сравнивается пара однотипных объектов
// на предмет их порядка (больше меньше).
public class Main {

    public static void main(String[] args) {
        Human vasya = new Human(70, false, "Vasya");
        Human petya = new Human(50, false, "Petya");
        Human masha = new Human(30, true, "Masha");
        Human tanya = new Human(40, true, "Tanya");

        List<Human> humans = Arrays.asList(vasya, petya, masha, tanya);
        humans.sort(new VaccinationComparator());// {tanya, masha, vasya, petya}
        System.out.println(humans);
    }
}

class Human {
    int age;
    boolean isDoctor;
    String name;

    public Human(int age, boolean isDoctor, String name) {
        this.age = age;
        this.isDoctor = isDoctor;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class VaccinationComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.isDoctor && !o2.isDoctor)
            return -1;
        if (!o1.isDoctor && o2.isDoctor)
            return 1;

        return o2.age - o1.age;
    }
}
