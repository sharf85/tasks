package de.telran;

public class Score {
    private final String name;
    private final long resultTime;

    public Score(String name, long resultTime) {
        this.name = name;
        this.resultTime = resultTime;
    }

    public String getName() {
        return name;
    }

    public long getResultTime() {
        return resultTime;
    }

    @Override
    public String toString() {
        return name + " issued credits for " + resultTime + " miliseconds\n";
    }
}
