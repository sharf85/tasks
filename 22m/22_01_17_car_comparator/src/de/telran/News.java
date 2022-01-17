package de.telran;

public class News implements Comparable<News>{
    String text;

    // from 1 to 10
    int priority;

    public News(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }

    //TODO the news which is of a higher priority must go first, if the priorities are equal, the shorter news
    // must go first.
    @Override
    public int compareTo(News o) {
        return 0;
    }
}
