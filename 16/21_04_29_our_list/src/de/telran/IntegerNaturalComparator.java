package de.telran;

import java.util.Comparator;

public class IntegerNaturalComparator implements Comparator<Integer> {
    @Override
    /**
     * the method must return a negative value if o1<o2, positive if o1>o2 and 0 if o1==o2
     */
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
