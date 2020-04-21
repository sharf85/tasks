package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.service.NumberService;
import org.springframework.web.bind.annotation.*;

@RestController
public class NumberController {

    NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    //TODO add number to a person, edit number, remove number, get by id
    @PostMapping("/number")
    public void create(@RequestBody NumberDto numberDto) {
        numberService.create(numberDto);
    }

    @GetMapping("/number/{id}")
    public void getById(@PathVariable int id) {

    }

    @PutMapping("/number")
    public void edit(@RequestBody NumberDto numberDto) {

    }

    @DeleteMapping("/number/{id}")
    public void removeById(@PathVariable int id) {

    }

}
