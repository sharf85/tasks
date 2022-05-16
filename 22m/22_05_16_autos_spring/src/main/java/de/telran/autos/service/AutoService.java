package de.telran.autos.service;

import de.telran.autos.model.Auto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoService {

    public void repaintAuto(Auto auto, String color) {
        auto.setColor(color);
    }

    public void printAutos(List<Auto> autos) {
        autos.forEach(System.out::println);
    }
}
