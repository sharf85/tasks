package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    @ResponseBody
    public void newPerson(@RequestBody PersonDto personDto) {
        personService.addPerson(personDto);
    }

    @GetMapping("/person")
    @ResponseBody
    public List<PersonDto> getAllPersons(@RequestParam(required = false) String name) {
        if (name != null && !name.equals(""))
            return personService.getAllByName(name);

        return personService.getAll();
    }
}
