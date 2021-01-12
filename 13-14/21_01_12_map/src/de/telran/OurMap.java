package de.telran;

import java.util.Iterator;

public interface OurMap<K, V> {

    public V put(K key, V value);

    public V get(K key);

    public V remove(K key);

    public int size();

    public Iterator<K> keyIterator();

    public Iterator<V> valueIterator();
}
