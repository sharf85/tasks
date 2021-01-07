package de.telran.autos.service;

import de.telran.autos.entity.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

// for autoconfig one can use the following annotations: @Component, @Service, @Repository
@Service
public class AutoService {
    public void printAutos(List<Auto> autos) {
        for (Auto auto : autos) {
            printAuto(auto);
        }
    }

    public void printAuto(Auto auto) {
        System.out.println(auto);
    }

    public void repaintAuto(Auto auto, String newColor) {
        auto.setColor(newColor);
    }
}
