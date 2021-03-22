package de.telran.autos;

import de.telran.autos.entity.Auto;
import de.telran.autos.service.AutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class OrderFlow implements ApplicationRunner {

    List<Auto> simpleAutos;
    Auto bentley;
    AutoService autoService;

    public OrderFlow(@Qualifier("simpleAutos") List<Auto> simpleAutos, Auto bentley, AutoService autoService) {
        this.simpleAutos = simpleAutos;
        this.bentley = bentley;
        this.autoService = autoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        autoService.print(simpleAutos);

        for (Auto auto : simpleAutos) {
            if (auto.getMake().equals("Opel"))
                autoService.paint(auto, "beige");
        }

        autoService.print(simpleAutos);

        autoService.print(bentley);

        autoService.paint(bentley, "violet");

        autoService.print(bentley);
    }
}
