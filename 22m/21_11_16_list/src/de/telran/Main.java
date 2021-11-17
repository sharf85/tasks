package de.telran;

import de.telran.list.AdvancedArrayList;
import de.telran.list.CustomArrayList;
import de.telran.list.CustomList;

public class Main {

    public static void main(String[] args) {

        CustomList list = new AdvancedArrayList();

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

        CustomList arrayList = new CustomArrayList();
        arrayList.add(6);
        arrayList.add(10);
        System.out.println(arrayList.size());//2
    }
}
