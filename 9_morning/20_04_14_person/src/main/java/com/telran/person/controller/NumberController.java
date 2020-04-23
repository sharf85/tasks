package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.service.NumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NumberController {

    NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/person/{personId}/number")
    public List<NumberDto> getNumbersByPersonId(@PathVariable int personId) {
        return numberService.getByPersonId(personId);
    }

    //TODO add number to a person, edit number, remove number, get by id
    @PostMapping("/person/{personId}/number")
    public void create(@RequestBody NumberDto numberDto, @PathVariable int personId) {
        numberDto.personId = personId;
        numberService.create(numberDto);
    }

    @GetMapping("/number/{id}")
//    @GetMapping("/person/{personId}/number/{id}")
    public NumberDto getById(@PathVariable int id) {
        return numberService.getById(id);
    }

    @PutMapping("/number")
//    @PutMapping("person/{personId}/number")
    public void edit(@RequestBody NumberDto numberDto) {
        numberService.edit(numberDto);
    }

    //    @DeleteMapping("person/{personId}/number/{id}")
    @DeleteMapping("number/{id}")
    public void removeById(@PathVariable int id) {
        numberService.removeById(id);
    }

}
