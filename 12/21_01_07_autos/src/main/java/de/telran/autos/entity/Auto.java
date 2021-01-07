package de.telran.autos.entity;

public class Auto {
    private String make;
    private String model;
    private String color;

    private int yearManufacture;
    private int mileage;

    public Auto(String make, String model, String color, int yearManufacture, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.yearManufacture = yearManufacture;
        this.mileage = mileage;
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

    public int getYearManufacture() {
        return yearManufacture;
    }

    public int getMileage() {
        return mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", mileage=" + mileage +
                '}';
    }
}
