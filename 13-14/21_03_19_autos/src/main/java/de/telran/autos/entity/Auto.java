package de.telran.autos.entity;

import java.time.LocalDate;

public class Auto {

    private final int id;
    private final String make;
    private String color;
    private final LocalDate yom;
    private int km;

    public Auto(int id, String make, String color, LocalDate yom, int km) {
        this(id, make, color, yom);
        this.km = km;
    }

    public Auto(int id, String make, String color, LocalDate yom) {
        this.id = id;
        this.make = make;
        this.color = color;
        this.yom = yom;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void addKm(int km) {
        this.km += km;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getYom() {
        return yom;
    }

    public int getKm() {
        return km;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", color='" + color + '\'' +
                ", yom=" + yom +
                ", km=" + km +
                '}';
    }
}
