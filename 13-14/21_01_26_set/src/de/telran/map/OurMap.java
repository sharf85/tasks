package de.telran.map;

import java.util.Iterator;

public interface OurMap<K, V> {

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    int size();

    Iterator<K> keyIterator();

    Iterator<V> valueIterator();
}
