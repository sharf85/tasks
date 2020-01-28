package com.telran;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {

        Map<Car, String> characteristicsByCar = fillCharacteristics();

        Car opel = new Car("Opel", "Astra", 2012);
        System.out.println(characteristicsByCar.get(opel));
    }

    private static Map<Car, String> fillCharacteristics() {
        Map<Car, String> res = new HashMap<>();
        Car opel = new Car("Opel", "Astra", 2012);
        Car citroen = new Car("Citroen", "C4", 2010);
        Car nissan = new Car("Nissan", "X-Trail", 2018);
        res.put(citroen, "Not for me");
        res.put(opel, "Wunderbar");
        res.put(nissan, "Top of top");

        return res;
    }

}

class Car {

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    private String brand;
    private String model;
    private int year;

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Car car = (Car) other;
        return year == car.year &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }
}
