package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.service.NumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("person/{id}/number")
    public List<NumberDto> getByPersonId(@PathVariable int id) {
        return numberService.getByPersonId(id);
    }

    @GetMapping("/number/{id}")
    public NumberDto getById(@PathVariable int id) {
        return numberService.getById(id);
    }

    @PutMapping("/number")
    public void getById(@RequestBody NumberDto numberIn) {
        numberService.edit(numberIn);
    }

    @DeleteMapping("/number/{id}")
    public void removeById(@PathVariable int id) {
        numberService.removeById(id);
    }

}
