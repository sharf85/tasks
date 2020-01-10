import collection.OurArrayList;
import collection.OurArrayListIterator;
import collection.OurLinkedList;
import collection.OurList;

import java.util.Iterator;

public class Application {
    public static void main(String... args) {
        OurArrayList<Integer> list = new OurArrayList<>();
        list.append(1);
        list.append(2);
        list.append(3);

//        Iterator<Integer> it = new OurArrayListIterator<>(list);
//        Iterator<Integer> it = list.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        for (int current : list) {
            System.out.print(current + " ");
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
