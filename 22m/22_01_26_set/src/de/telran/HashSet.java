package de.telran;

import java.util.HashMap;
import java.util.Iterator;

public class HashSet<T> implements Set<T> {

    private final Object o = new Object();
    private HashMap<T, Object> source;

    @Override
    public boolean add(T elt) {
        return source.put(elt, o) == null;
    }

    @Override
    public boolean remove(T elt) {
        return source.remove(elt) != null;
    }

    @Override
    public boolean contains(T elt) {
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public void addAll(Set<T> another) {
        for (T newElt : another) {
            this.add(newElt);
        }
    }

    @Override
    public void removeAll(Set<T> another) {
        for (T newElt : another) {
            this.remove(newElt);
        }
    }

    @Override
    public void retainAll(Set<T> another) {
        //TODO complete
    }

    @Override
    public Iterator<T> iterator() {
        return source.keySet().iterator();
    }
}
