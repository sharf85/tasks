package de.telran.autoservice.entity;

public class Auto {

    private String make;
    private String color;

    public Auto(String make, String color) {
        this.make = make;
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "make='" + make + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
