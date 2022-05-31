package de.telran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomSet<T> implements IRandomSet<T> {

    private ArrayList<T> list = new ArrayList<>();
    private HashMap<T, Integer> eltToIndex = new HashMap<>();
    Random rnd = new Random();

    @Override
    public boolean add(T elt) {
        if (eltToIndex.containsKey(elt))
            return false;

        eltToIndex.put(elt, list.size());
        list.add(elt);
        return true;
    }

    @Override
    public boolean remove(T elt) {
        if (!eltToIndex.containsKey(elt))
            return false;

        int indexToRemove = eltToIndex.get(elt);

        T lastElt = list.get(list.size() - 1);
        list.set(indexToRemove, lastElt);
        list.remove(list.size() - 1);
        eltToIndex.put(lastElt, indexToRemove);
        eltToIndex.remove(elt);
        return true;
    }

    @Override
    public T getRandom() {
        int randomIndex = rnd.nextInt(list.size());
        return list.get(randomIndex);
    }
}
