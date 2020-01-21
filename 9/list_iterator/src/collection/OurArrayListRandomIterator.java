package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OurArrayListRandomIterator<E> implements Iterator<E> {

    private List<E> cached;

    private int currentId;

    public OurArrayListRandomIterator(OurArrayList<E> list) {
        cached = new ArrayList<>();
        for (E elt : list) {
            cached.add(elt);
        }
        Collections.shuffle(cached);
    }

    @Override
    public boolean hasNext() {
        return currentId < cached.size();
    }

    @Override
    public E next() {
        return cached.get(currentId++);
    }
}
