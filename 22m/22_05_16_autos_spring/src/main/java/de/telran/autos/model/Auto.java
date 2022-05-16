package de.telran.autos.model;

import org.springframework.stereotype.Component;

public class Auto {
    private final String make;
    private final String model;
    private final int yom;
    private String color;
    private int km;

    public Auto(String make, String model, int yom, String color) {
        this.make = make;
        this.model = model;
        this.yom = yom;
        this.color = color;
    }

    public Auto(String make, String model, int yom, String color, int km) {
        this.make = make;
        this.model = model;
        this.yom = yom;
        this.color = color;
        this.km = km;
    }

    public void addKm(int moreKm) {
        km += moreKm;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYom() {
        return yom;
    }

    public int getKm() {
        return km;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yom=" + yom +
                ", color='" + color + '\'' +
                ", km=" + km +
                '}';
    }
}
