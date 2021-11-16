package de.telran;

import de.telran.list.AdvancedArrayList;
import de.telran.list.CustomList;

public class Main {

    public static void main(String[] args) {

        CustomList list = new AdvancedArrayList();

        list.add(10);
        list.add(15);
        list.add(3);//{10, 15, 3}
    }
}
