package de.telran;

public class Score {
    String name;
    long time;

    public Score(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return name + " ran the distance for " + time + " miliseconds\n";
    }
}
