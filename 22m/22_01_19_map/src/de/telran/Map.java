package de.telran;

public interface Map<K, V> {

    /**
     * The method puts the value corresponding to the key. If the pair with the key exists, then the value will
     * be replaced
     *
     * @param key not null
     * @param value
     */
    void put(K key, V value);

    /**
     * returns the value corresponding to the key. If there is no such a key, then null will be returned
     * @param key not null
     * @return
     */
    V get(K key);

    /**
     * removes the pair with the key and returns the value. Or returns null, if there is no such a key.
     * @param key not null
     * @return
     */
    V remove(K key);

    /**
     * returns true if there is a pair with the key. false otherwise
     * @param key not null
     * @return
     */
    boolean contains(K key);

    int size();

}
