package com.telran.controller;

import com.telran.dto.HelloDTO;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {

    @GetMapping("hello/{name}")
    public HelloDTO getHello(@PathVariable String name, @PathParam("id") int id) {
        return new HelloDTO(name, id);
    }

}
