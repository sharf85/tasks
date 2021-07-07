package de.telran.autoservice;

import de.telran.autoservice.entity.Auto;
import de.telran.autoservice.service.AutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoFlow implements ApplicationRunner {

    private final AutoService autoService;

    private final Auto opel;
    private final Auto mazda;
    private final Auto bentley;
    private final List<Auto> simpleAutos;

    public AutoFlow(AutoService autoService,
                    Auto opel,
                    Auto mazda,
                    Auto bentley,
                    @Qualifier("simple")
                            List<Auto> simpleAutos) {
        this.autoService = autoService;
        this.opel = opel;
        this.mazda = mazda;
        this.bentley = bentley;
        this.simpleAutos = simpleAutos;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        autoService.print(mazda);
        autoService.paint(mazda, "pink");
        autoService.print(mazda);

        autoService.print(simpleAutos);
    }
}
