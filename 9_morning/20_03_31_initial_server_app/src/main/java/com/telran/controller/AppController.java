package com.telran.controller;

import com.telran.dto.HelloJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("hello/{name}")
    public HelloJson getHello(@PathVariable("name") String name) {
        return new HelloJson(name);
    }
}
