package de.telran;

/**
 * The natural ordering is as follows:
 * The news item has larger priority, if it is more positive and shorter
 */
public class News implements Comparable<News> {
    String text;

    // 1 to 10
    int positivity;

    public News(String text, int positivity) {
        this.text = text;
        this.positivity = positivity;
    }

    public String getText() {
        return text;
    }

    public int getPositivity() {
        return positivity;
    }

    @Override
    public int compareTo(News other) {
        int res = this.positivity - other.positivity;
        if (res != 0)
            return res;
        return other.text.length() - this.text.length();
    }

    @Override
    public String toString() {
        return "News{" +
                "text='" + text + '\'' +
                ", positivity=" + positivity +
                '}';
    }
}
