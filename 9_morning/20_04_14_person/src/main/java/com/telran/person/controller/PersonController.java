package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import com.telran.person.validation.ViolationDto;
import com.telran.person.validation.annotation.FullName;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void create(@RequestBody @Valid PersonDto personDto) {
        personService.add(personDto);
    }

    @PutMapping("/person")
    public void edit(@RequestBody @Valid PersonDto personDto) {
        personService.edit(personDto);
    }

    @GetMapping("/person/{id}")
    public PersonDto getById(@PathVariable @Min(1) int id) {
        return personService.getById(id);
    }

    @DeleteMapping("/person/{id}")
    public void removeById(@PathVariable int id) {
        personService.removeById(id);
    }

    @GetMapping("/person/name/{name}")
    public List<PersonDto> getAllByName(@PathVariable String name) {
        return personService.getAllByName(name);
    }

    @GetMapping("/person")
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/age")
    public List<PersonDto> getAllFilteredByAge(@RequestParam(required = false, defaultValue = "0") int min,
                                               @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int max) {
        return personService.getAllConstrainedByAge(min, max);
    }

}
