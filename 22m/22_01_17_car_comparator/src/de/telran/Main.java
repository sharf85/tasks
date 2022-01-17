package de.telran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(new Car(100000, 2015), new Car(50000, 2010));
//        Collections.sort(cars, );
        List<String> string = Arrays.asList("Hello world", "abc", "xyz");
        Collections.sort(string);


    }
}
