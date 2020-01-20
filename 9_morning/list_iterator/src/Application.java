import com.telran.collection.OurArrayList;
import com.telran.collection.OurArrayListRandomIterator;
import com.telran.collection.OurLinkedList;

import java.util.Iterator;

public class Application {

    public static void main(String... args) {
        OurArrayList<Integer> ints = new OurArrayList<>();
        ints.append(54);
        ints.append(1);
        ints.append(4);
        ints.append(5);

//        Iterator<Integer> iterator = new OurArrayListIterator<>(ints);
        Iterator<Integer> iterator = ints.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

//        random iterator
        Iterator<Integer> randomIt = new OurArrayListRandomIterator(ints);

        while (randomIt.hasNext()) {
            System.out.print(randomIt.next() + " ");
        }
        System.out.println();

//        the same with for each
        for (Integer num : ints) {
            System.out.print(num + " ");
        }
        System.out.println();


//        linked list
        OurLinkedList<Integer> linkedInts = new OurLinkedList<>();
        linkedInts.append(54);
        linkedInts.append(1);
        linkedInts.append(4);
        linkedInts.append(5);

        Iterator<Integer> linkedIterator = linkedInts.iterator();

        while (linkedIterator.hasNext()) {
            System.out.print(linkedIterator.next() + " ");
        }
        System.out.println();

//        the same with for each
        for (Integer num : linkedInts) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
