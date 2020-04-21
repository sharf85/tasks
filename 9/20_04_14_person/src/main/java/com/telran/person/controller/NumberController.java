package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.service.NumberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
    final private NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/person/{id}/number")
    public void create(@PathVariable("id") int personId, @RequestBody NumberDto numberIn) {
        numberIn.personId = personId;
        numberService.create(numberIn);
    }

    //TODO edit, get, remove
}
