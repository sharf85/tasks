package com.telran.server_app.controller;

import com.telran.server_app.dto.CourseDTO;
import com.telran.server_app.dto.JsonHelloDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("helloVar", "Hello ");
        return "hello";
    }

    @GetMapping("string-hello/{name}")
    @ResponseBody
    public String stringHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("json-hello/{name}")
    @ResponseBody
    public JsonHelloDTO jsonHello(@PathVariable("name") String name) {
        return new JsonHelloDTO(name,
                120,
                Arrays.asList(new CourseDTO("Tel-Ran"), new CourseDTO("Deutsch")));
    }
}
