package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.entity.Person;
import com.telran.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseBody
    @PostMapping("/person")
    public void createPerson(@RequestBody PersonDto personDto) {
        personService.create(personDto);
    }

//    @ResponseBody
//    @GetMapping("/person")
//    public List<PersonDto> getAll() {
//        return personService.getAll();
//    }

    @ResponseBody
    @GetMapping("/person")
    public List<PersonDto> getByName(@RequestParam(value = "name", required = false) String firstName) {
        return firstName == null ? personService.getAll() : personService.getByName(firstName);
    }


}
