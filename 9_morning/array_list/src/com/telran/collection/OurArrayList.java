package com.telran.collection;

import com.telran.comparator.OurComparator;

public class OurArrayList<E> implements OurList<E> {

    private Object[] source;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void append(E o) {
        if (size == source.length) {
            Object[] newSource = new Object[size * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = o;
        size++;
    }

    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (E) source[index];
    }

    public void set(E o, int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = o;
    }

    public E removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Object o = source[index];
        System.arraycopy(source, index + 1, source, index, size - index);
        size--;

        return (E) o;
    }

    public boolean remove(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(source[i])) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(source[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E max(OurComparator<E> comparator) {
        if (size == 0)
            throw new EmptyListException();

        E max = (E) source[0];

        for (int i = 1; i < size; i++) {
            if (comparator.compare(max, (E) source[i]) < 0)
                max = (E) source[i];
        }
        return max;
    }

    @Override
    public E min(OurComparator<E> comparator) {
        if (size == 0)
            throw new EmptyListException();

//        return max(new OurComparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return -comparator.compare(o1, o2);
//            }
//        });

//        return max((o1, o2) -> -comparator.compare(o1, o2));


        E min = (E) source[0];

        for (int i = 1; i < size; i++) {
            if (comparator.compare(min, (E) source[i]) > 0)
                min = (E) source[i];
        }
        return min;
    }

    @Override
    public void sort(OurComparator<E> comparator) {
        for (int i = 0; i < size; i++) {

            int minId = i;

            for (int j = i; j < size; j++) {
                if (comparator.compare((E) source[minId], (E) source[j]) > 0) {
                    minId = j;
                }
            }

            Object temp = source[i];
            source[i] = source[minId];
            source[minId] = temp;
        }
    }
}
