package de.telran;

public class Auto {

    String make;
    int year;
    String color;

    public Auto(String make, int year, String color) {
        this.make = make;
        this.year = year;
        this.color = color;
    }

    @Override
    public boolean equals(Object o2) {
        if (!(o2 instanceof Auto))
            return false;

        Auto auto2 = (Auto) o2;

        return this.year == auto2.year
                && this.make.equals(auto2.make)
                && this.color.equals(auto2.color);
    }

    @Override
    public String toString() {
        return "The make: " + make + ", the year: " + year + ", the color: " + color;
    }
}
