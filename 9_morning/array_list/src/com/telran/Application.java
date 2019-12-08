package com.telran;

import com.telran.collection.OurArrayList;

import java.util.Objects;

public class Application {

    public static void main(String[] args) {

        OurArrayList list = createListOfHumans();

        Human anotherVasya = new Human("Vasily", 20);

        list.remove(anotherVasya);//false
        System.out.println(list.size());
    }

    private static OurArrayList createListOfHumans() {
        Human vasya = new Human("Vasily", 20);
        Human petya = new Human("Petr", 21);
        Human masha = new Human("Maria", 22);

        OurArrayList list = new OurArrayList();
        list.append(vasya);
        list.append(petya);
        list.append(masha);
        return list;
    }


}

class Human {
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
