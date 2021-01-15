package de.telran;

import java.util.Iterator;

/**
 * The implementation of OurMap can not contain null as a key.
 *
 * @param <K>
 * @param <V>
 */
public class OurHashMap<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;

    private Pair<K, V>[] source;
    private int size;
    private double loadFactor;
    private int capacity;

    public OurHashMap() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    static int hash(Object key) {
        return Math.abs(key.hashCode());
    }

    public OurHashMap(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity)
            resize();

        Pair<K, V> pair = find(key);

        if (pair != null) {
            V res = pair.value;
            pair.value = value;
            return res;
        }

        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair<>(key, value, source[index]);
        source[index] = newPair;
        size++;
        return null;
    }

    private void resize() {
        capacity = capacity * 2;
        Pair<K, V>[] newSource = new Pair[capacity];

        for (Pair<K, V> cell : source) {

            Pair<K, V> currentPair = cell;
            while (currentPair != null) {
                int newIndex = hash(currentPair.key) % capacity;
                Pair<K, V> next = currentPair.next;

                currentPair.next = newSource[newIndex];
                newSource[newIndex] = currentPair;

                currentPair = next;
            }
        }

        source = newSource;
    }

    private Pair<K, V> find(K key) {
        int index = hash(key) % capacity;
//        int index = Math.abs(key.hashCode() % capacity);

        Pair<K, V> current = source[index];
        while (current != null) {
            if (key.equals(current.key))
                return current;
            current = current.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = find(key);
        return pair == null ? null : pair.value;
    }

    @Override
    public V remove(K key) {
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];

        if (current == null)
            return null;

        if (current.key.equals(key)) {
            source[index] = current.next;
            V res = current.value;

            clearPair(current);

            size--;
            return res;
        }

        while (current.next != null) {
            if (current.next.key.equals(key)) {
                Pair<K, V> pairToRemove = current.next;
                V res = pairToRemove.value;
                current.next = pairToRemove.next;

                clearPair(pairToRemove);

                size--;
                return res;
            }
            current = current.next;
        }

        return null;
    }

    private void clearPair(Pair<K, V> pair) {
        pair.next = null;
        pair.value = null;
        pair.key = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K> {

        int index = 0;
        int position = 0;
        Pair<K, V> currentPair;

        KeyIterator() {
            if (size == 0)
                return;

            while (source[index] == null) {
                index++;
            }

            currentPair = source[index];
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public K next() {
            if (position >= size)
                throw new IndexOutOfBoundsException();

            K res = currentPair.key;

            if (currentPair.next != null) {
                currentPair = currentPair.next;
            } else {
                do {
                    index++;
                } while (index < capacity && source[index] == null);

                currentPair = index < capacity ? source[index] : null;
            }

            position++;
            return res;
        }
    }

    @Override
    public Iterator<V> valueIterator() {
        return new Iterator<V>() {

            final KeyIterator keyIterator = new KeyIterator();

            @Override
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            @Override
            public V next() {
                return get(keyIterator.next());
            }
        };
    }

    static private class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

//        public K getKey() {
//            return key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public Pair<K, V> getNext() {
//            return next;
//        }
    }
}
