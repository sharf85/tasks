package de.telran.autos;

import de.telran.autos.entity.Auto;
import de.telran.autos.service.AutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoFlow implements ApplicationRunner {

    final List<Auto> autos;
    final AutoService autoService;
    final Auto bentley;

    public AutoFlow(@Qualifier("simpleAutos") List<Auto> autos,
                    AutoService autoService,
                    // the name of the argument is important
                    Auto silverBentley) {
        this.autos = autos;
        this.autoService = autoService;
        this.bentley = silverBentley;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        autoService.printAutos(autos);

        for (Auto auto : autos) {
            if (auto.getMake().equals("Opel")) {
                autoService.repaintAuto(auto, "grey");
            }
        }

        System.out.println("After repaint Opels:");
        autoService.printAutos(autos);

        System.out.println("And here we have Bentley!");
        autoService.printAuto(bentley);
    }
}
