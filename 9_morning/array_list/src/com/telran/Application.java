package com.telran;

import com.telran.collection.OurArrayList;

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
