package de.telran;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Map<Auto, String> map = new HashMap<>();
        fillMap(map);

        // Рекомендуется в качестве ключей для HashMap использовать только те объекты,
        // у которых переопределены hashCode и equals, а также они immutable (не изменяются
        // с момента создания)
        Auto anotherGreyOpel = new Auto("Grey", "Opel");
        String value = map.get(anotherGreyOpel);
        System.out.println(value);//
    }

    static void fillMap(Map<Auto, String> map) {
        Auto greyOpel = new Auto("Grey", "Opel");
        map.put(greyOpel, "Value of grey opel");
    }
}

class Auto {
    private final String make;

    private final String color;

    public Auto(String make, String color) {
        this.make = make;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return Objects.equals(make, auto.make) &&
                Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, color);
    }
}
