package de.telran.persons.controller;

import de.telran.persons.model.Person;
import de.telran.persons.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String home() {
        return "forward:/persons";
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "persons";
    }

    @GetMapping("/person/{id}")
    public String person(Model model, @PathVariable Integer id) {
        model.addAttribute("person", personService.get(id));
        return "person";
    }

    @GetMapping("/person/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "edit-person";
    }

    @GetMapping("/person/{id}/edit")
    public String newPerson(Model model, @PathVariable int id) {
        model.addAttribute("person", personService.get(id));
        return "edit-person";
    }

    @PostMapping("/save-person")
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/person/{id}/delete")
    public String delete(@PathVariable int id) {
        personService.remove(personService.get(id));
        return "redirect:/";
    }
}
