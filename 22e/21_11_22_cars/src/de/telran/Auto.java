package de.telran;

public class Auto extends Object {

    public Auto(String make, int year, String color) {
        this.make = make;
        this.year = year;
        this.color = color;
    }

    String make;
    int year;
    String color;

    public boolean equals(Object o2) {
        if (!(o2 instanceof Auto))
            return false;

        Auto auto2 = (Auto) o2;

        if (this.make.equals(auto2.make)
                && this.year == auto2.year
                && this.color.equals(auto2.color))
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "The make: " + make + ". The year: " + year + ". The color: " + color;
    }
}
