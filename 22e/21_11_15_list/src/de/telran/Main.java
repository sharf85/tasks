package de.telran;

import de.telran.list.AdvancedArrayList;
import de.telran.list.CustomArrayList;
import de.telran.list.CustomList;

public class Main {

    public static void main(String[] args) {
        CustomList list = new AdvancedArrayList(5);

        CustomList arrayList = new CustomArrayList();

        arrayList.add(10);
        arrayList.add(18);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(50);

        arrayList.println();//{10, 18, 3, -5, 50}

        arrayList.set(0, 10);
        arrayList.set(1, 5);
        arrayList.set(2, 20);

        arrayList.println();//{10, 5, 20, -5, 50}

        arrayList.add(99);
        arrayList.println();//{10, 5, 20, -5, 50, 99}

        arrayList.removeById(2);
        arrayList.println();//{10, 5, -5, 50, 99}
    }
}
