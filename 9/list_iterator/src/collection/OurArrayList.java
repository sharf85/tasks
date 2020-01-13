package collection;

import java.util.Iterator;

public class OurArrayList<E> implements OurList<E> {

    private Object[] source;
    private static final int INITIAL_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E o) {
        return false;
    }

    @Override
    public void append(E value) {
        if (source.length == size) {
            E[] newSource = (E[]) new Object[source.length * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = value;
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (E) source[index];
    }

    @Override
    public void set(E value, int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }

    @Override
    public boolean remove(E value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(value)) {
                removeById(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public E removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        E result = (E) source[index];

        System.arraycopy(source, index + 1, source, index, source.length - (index + 1));
        size--;
        return result;
    }

    public E max(AbstractComparator co) {
        if (source.length == 0)
            throw new EmptyListException();

        E max = (E) source[0];
        for (int i = 1; i < size; i++) {
            if (co.compare(max, source[i]) < 0)
                max = (E) source[i];
        }

        return max;
    }

    public E min(AbstractComparator comparator) {

//        AbstractComparator invertedComparator = new AbstractComparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return -comparator.compare(o1, o2);
//            }
//        };
//
//        return max(invertedComparator);

        if (source.length == 0)
            throw new EmptyListException();

        E min = (E) source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(min, source[i]) > 0)
                min = (E) source[i];
        }

        return min;
    }

    public void sort(AbstractComparator comparator) {
        int length = size;

        for (int i = 0; i < length; i++) {
            int minId = i;

            for (int j = i; j < length; j++) {
                if (comparator.compare(source[minId], source[j]) > 0)
                    minId = j;

            }

            E temp = (E) source[minId];
            source[minId] = source[i];
            source[i] = temp;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new OurArrayListIterator<>(this);
    }
}
