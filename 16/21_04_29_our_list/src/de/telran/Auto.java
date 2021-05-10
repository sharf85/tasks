package de.telran;

import java.util.Objects;

public class Auto {
    private String make;
    private String color;
    private long price;

    public Auto(String make, String color, long price) {
        this.make = make;
        this.color = color;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return price == auto.price && Objects.equals(make, auto.make) && Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, color, price);
    }
}
