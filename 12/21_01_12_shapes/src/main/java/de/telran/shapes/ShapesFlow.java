package de.telran.shapes;

import de.telran.shapes.entity.Picture;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ShapesFlow implements ApplicationRunner {

    private final Picture picture;

    public ShapesFlow(Picture picture) {
        this.picture = picture;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        picture.draw();
    }
}
