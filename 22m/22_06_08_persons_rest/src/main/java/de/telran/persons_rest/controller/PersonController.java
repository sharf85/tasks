package de.telran.persons_rest.controller;

import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Get the person by id
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person get(@PathVariable Integer id) {
        return personService.get(id);
    }

    /**
     * Greate a new person
     */
    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping
    public void edit(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.remove(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    // TODO create an endpoint, finding all persons with such a name. /api/persons?name=Vasya&lastname=Vasin
    // TODO create an endpoint, finding all persons with such a lastname
    // TODO create an endpoint finding all persons with the age larger some query parameter

}
