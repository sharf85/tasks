package de.telran;

public class Main {

    public static void main(String[] args) {
        IntegerList list1 = new ArrayIntegerList();
        IntegerList list2 = new ArrayIntegerList();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        list2.addLast(-1);
        list2.addLast(-2);
        list2.addLast(-3);

        // print list1 out
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        // print list2 out
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
    }
}
