package com.example.shapes_spring;

import com.example.shapes_spring.model.Picture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Application implements CommandLineRunner {

    private final Picture picture1;
    private final Picture picture2;

    public Application(Picture picture1, Picture picture2) {
        this.picture1 = picture1;
        this.picture2 = picture2;
    }

    @Override
    public void run(String... args) throws Exception {
        picture1.draw();
        picture2.draw();
    }
}
