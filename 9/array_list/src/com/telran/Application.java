package com.telran;

import com.telran.collection.OurArrayList;

public class Application {

    public static void main(String[] args) {
        OurArrayList list = makeHumanList();

        Human anotherPetya = new Human("Petya", 20);
        list.remove(anotherPetya);

        System.out.println(anotherPetya);
        System.out.println(anotherPetya.toString());
    }

    static OurArrayList makeHumanList() {
        Human vasya = new Human("Vasya", 20);
        Human petya = new Human("Petya", 20);
        Human masha = new Human("Masha", 20);

        OurArrayList res = new OurArrayList();
        res.add(vasya);
        res.add(petya);
        res.add(masha);
        return res;
    }

}
