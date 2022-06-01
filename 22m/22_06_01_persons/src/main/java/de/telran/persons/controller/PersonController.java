package de.telran.persons.controller;

import de.telran.persons.model.Person;
import de.telran.persons.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "";
    }

    @GetMapping("/new-person")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "edit-person";
    }

    @PostMapping("/save-person")
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/";
    }
    //TODO доделать необходимые эндпоинты
}
