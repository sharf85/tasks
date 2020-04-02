package com.telran.controller;

import com.telran.dto.HelloDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class HelloController {

    @GetMapping("hello/{name}")
    @ResponseBody
    public HelloDTO getHello(@PathVariable String name) {
        return new HelloDTO(name);
    }

    @GetMapping("greetings/{name}")
    public String getGreetings(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "greetings";
    }

}
