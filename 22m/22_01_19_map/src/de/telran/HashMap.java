package de.telran;

// TODO investigate and complete and test
public class HashMap<K, V> implements Map<K, V> {

    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private Pair<K, V>[] source = new Pair[INITIAL_CAPACITY];


    private static class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(K key, V value) {
        if (size > LOAD_FACTOR * source.length)
            resize();

        Pair<K, V> pair = findPair(key);

        if (pair == null) {
            int index = findIndex(key);
            pair = new Pair<>(key, value, source[index]);
            source[index] = pair;
            size++;
        } else {
            pair.value = value;
        }
    }

    private void resize() {

    }

    private int findIndex(K key) {
        return Math.abs(key.hashCode()) % source.length;
    }

    /**
     * retuns the pair with the key or null if there is no pair with such a key
     *
     * @param key
     * @return
     */
    private Pair<K, V> findPair(K key) {
        int index = findIndex(key);

        Pair<K, V> currentPair = source[index];

        while (currentPair != null) {
            if (currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next;
        }

        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
