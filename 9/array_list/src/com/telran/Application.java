package com.telran;

import com.telran.collection.OurArrayList;

import java.util.Collection;
import java.util.List;

public class Application {

    public static void main(String[] args) {
//        OurArrayList list = makeHumanList();
//
//        Human anotherPetya = new Human("Petya", 20);
//        list.remove(anotherPetya);
//
//        System.out.println(anotherPetya);
//        System.out.println(anotherPetya.toString());
    }

    static OurArrayList makeHumanList() {
        Human vasya = new Human("Vasya", 20);
        Human petya = new Human("Petya", 20);
        Human masha = new Human("Masha", 20);

        OurArrayList res = new OurArrayList();
        res.append(vasya);
        res.append(petya);
        res.append(masha);
        return res;
    }

}

class SomeType<T> {
    public void test(Collection collection) {
        for (Object element : collection) {
            System.out.println(element);
        }
    }

    public void test(List<Integer> collection) {
        for (Integer element : collection) {
            System.out.println(element);
        }
    }
}
