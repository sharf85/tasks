package de.telran;

import de.telran.list.AdvancedArrayList;
import de.telran.list.CustomArrayList;
import de.telran.list.CustomList;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        CustomList<Integer> list = new CustomArrayList<>();


        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            System.out.println(number);
        }


        for (int number : list) {
            System.out.println(number);
        }


        list.add(10);
        list.add(15);
        list.add(3);//{10, 15, 3}

        list.println();

        list.insert(2, 7);//{10, 15, 7, 3}
        list.println();

        list.removeById(0);//{15, 7, 3}
        list.println();

        list.removeById(2);//{15, 7}
        list.println();


    }
}
