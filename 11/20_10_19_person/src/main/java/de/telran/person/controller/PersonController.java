package de.telran.person.controller;

import de.telran.person.dto.PersonDto;
import de.telran.person.model.Person;
import de.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonController {

    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{id}")
    public PersonDto get(@PathVariable int id) {
        Person person = personService.get(id);
        return new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge());
    }

    @GetMapping("/persons")
    public List<PersonDto> getAll() {
        List<Person> persons = personService.getAll();
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }

    @PostMapping("/persons")
    public PersonDto create(@RequestBody PersonDto personDto) {
        Person person = personService.create(personDto.name, personDto.secondName, personDto.age);
        personDto.id = person.getId();
        return personDto;
    }

    @PutMapping("/persons/{id}")
    public void edit(@RequestBody PersonDto personDto, @PathVariable int id) {
        personService.edit(id, personDto.name, personDto.secondName, personDto.age);
    }

    @DeleteMapping("/persons/{id}")
    public PersonDto delete(@PathVariable int id) {
        Person person = personService.remove(id);
        return new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge());
    }

    // /persons/name/Vasily
    @GetMapping("/persons/name/{name}")
    public List<PersonDto> getAllByName(@PathVariable String name) {
        List<Person> persons = personService.getAllByName(name);
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/second-name")
    public List<PersonDto> getAllBySecondNameContaining(@RequestParam String pattern) {
        List<Person> persons = personService.getAllBySecondNameContainingPattern(pattern);
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }

    // /persons/age?after=10&before=20
    @GetMapping("/persons/age")
    public List<PersonDto> getAllByAgeBetween(@RequestParam(required = false, defaultValue = "0") int from,
                                              @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int to) {
        List<Person> persons = personService.getAllByAgeBetween(from, to);
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }


}
