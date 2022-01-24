package de.telran;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Map<Auto, Integer> priceByAuto = fillPrices();
        Auto opelInsigniaOuter = new Auto("Opel", "Insignia");

        System.out.println(priceByAuto.containsKey(opelInsigniaOuter));//true
        System.out.println(priceByAuto.get(opelInsigniaOuter));//10000

        priceByAuto.put(opelInsigniaOuter, 15000);
    }

    static Map<Auto, Integer> fillPrices() {
        Auto opelInsignia = new Auto("Opel", "Insignia");
        Auto vwGolf = new Auto("VW", "Golf");

        Map<Auto, Integer> priceByAuto = new HashMap<>();

        priceByAuto.put(opelInsignia, 10000);
        priceByAuto.put(vwGolf, 15000);

        return priceByAuto;
    }

}

class Auto {
    private final String make;
    private final String model;

    public Auto(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return Objects.equals(make, auto.make) && Objects.equals(model, auto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model);
    }
}
