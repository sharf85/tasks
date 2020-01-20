import collection.OurArrayList;
import collection.OurArrayListRandomIterator;
import collection.OurLinkedList;

import java.util.Iterator;

public class Application {
    public static void main(String... args) {
        OurArrayList<Integer> list = new OurArrayList<>();
        list.append(1);
        list.append(2);
        list.append(3);

//        Iterator<Integer> it = new OurArrayListIterator<>(list);
        Iterator<Integer> it = list.iterator();
//
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for (int current : list) {
            System.out.print(current + " ");
        }
        System.out.println();

// array list random iterator;

        Iterator<Integer> randomIt = new OurArrayListRandomIterator<>(list);
        System.out.println("Randomchik: ");
        while (randomIt.hasNext()) {
            System.out.print(randomIt.next() + " ");
        }
        System.out.println();
//linked list
        OurLinkedList<Integer> linkedList = new OurLinkedList<>();
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);

        for (int current : linkedList) {
            System.out.print(current + " ");
        }
    }
}
