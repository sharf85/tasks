package com.telran.second_server_app.controller;

import com.telran.second_server_app.dto.HelloDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello/{name}")
    public String getHello(@PathVariable String name, Model model) {
        model.addAttribute("staticName", "Static Name");
        return "hello";
    }

    @GetMapping("hello-string/{name}")
    @ResponseBody
    public String getStringHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("hello-json/{name}")
    @ResponseBody
    public HelloDTO getJsonHello(@PathVariable String name) {
        return new HelloDTO(name);
    }
}
