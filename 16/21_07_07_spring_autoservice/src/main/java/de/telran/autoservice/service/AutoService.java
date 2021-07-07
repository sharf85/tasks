package de.telran.autoservice.service;

import de.telran.autoservice.entity.Auto;
import org.springframework.stereotype.Component;

@Component
public class AutoService {

    public void paint(Auto auto, String color) {
        auto.setColor(color);
    }

    public void print(Auto auto) {
        System.out.println(auto);
    }

    public void print(Iterable<Auto> autos) {
        autos.forEach(System.out::println);
    }
}
