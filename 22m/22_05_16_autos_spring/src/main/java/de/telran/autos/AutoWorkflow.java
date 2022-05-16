package de.telran.autos;

import de.telran.autos.model.Auto;
import de.telran.autos.service.AutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// tells Spring to an instance of AutoWorkflow
@Component
public class AutoWorkflow
// tells spring, that after creation of the instance, it is necessary to run the 'run' method
        implements CommandLineRunner {

    private final AutoService autoService;

    private final Auto opel;
    private final Auto mazda;
    private final Auto bentley;
    private final List<Auto> autos;
    private final List<Auto> cheapAutos;

    public AutoWorkflow(AutoService autoService,
                        Auto opel,
                        Auto mazda,
                        Auto bentley,
                        List<Auto> autos,
                        @Qualifier("cheapAutos") List<Auto> cheapAutos){
        this.autoService = autoService;
        this.opel = opel;
        this.mazda = mazda;
        this.bentley = bentley;
        this.autos = autos;
        this.cheapAutos = cheapAutos;

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Spring");

        autoService.repaintAuto(mazda, "blue");

//        autoService.printAutos(autos);
        autoService.printAutos(cheapAutos);
    }
}
