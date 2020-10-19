package de.telran.person.controller;

import de.telran.person.dto.PersonDto;
import de.telran.person.model.Person;
import de.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {


    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{id}")
    public PersonDto get(@PathVariable int id) {
        return null;
    }

    @GetMapping("/persons")
    public List<PersonDto> getAll() {
        return null;
    }

    @PostMapping("/persons")
    public PersonDto create(@RequestBody PersonDto personDto) {
        Person person = personService.create(personDto.name, personDto.secondName, personDto.age);
        personDto.id = person.getId();
        return personDto;
    }

    @PutMapping("/persons/{id}")
    public void edit(@RequestBody PersonDto personDto, @PathVariable int id) {

    }

    @DeleteMapping("/persons/{id}")
    public PersonDto delete(@PathVariable int id) {
        return null;
    }
}
