package de.telran;

public final class OurInteger implements Comparable<OurInteger> {

    private final int source;

    public OurInteger(int source) {
        this.source = source;
    }

    public int getSource() {
        return source;
    }

    @Override
    public int compareTo(OurInteger other) {
//        if (this.source < other.source)
//            return -10;// Integer.MIN_VALUE
//
//        else if (this.source > other.source)
//            return 5;
//
//        return 0;
        return this.source - other.source;
    }
}
