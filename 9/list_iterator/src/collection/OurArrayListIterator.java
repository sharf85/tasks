package collection;

import java.util.Iterator;

public class OurArrayListIterator<E> implements Iterator<E> {

    private OurArrayList<E> list;

    public OurArrayListIterator(OurArrayList<E> list) {
        this.list = list;
    }

    int currentEltId = 0;

    @Override
    public boolean hasNext() {
        return currentEltId < list.size();
    }

    @Override
    public E next() {
        return list.get(currentEltId++);
    }
}
