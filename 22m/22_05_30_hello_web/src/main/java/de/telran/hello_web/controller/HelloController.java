package de.telran.hello_web.controller;

import de.telran.hello_web.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//let Spring know that this is a controller to place it into MVC configuration
@Controller
public class HelloController {

    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    // to return a simple string in the http response body
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping(value = "/hello-world-html", method = RequestMethod.GET)
    // to return a simple string in the http response body
    @ResponseBody
    public String helloWorldHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Hello World!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    // the same as @RequestMapping, but with specified http method GET
    // to serve all requests like: "/hello/Vasya", "/hello/Petya", "/hello/somebody"
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/hello-thymeleaf/{name}")
    public String helloThymeleaf(@PathVariable String name, Model model) {
        model.addAttribute("nameToShow", name);
        return "hello";
    }

    @PostMapping("/post-hello")
    @ResponseBody
    public String postHello(@ModelAttribute Person person) {
        return "name: " + person.getName() + " lastname: " + person.getLastname();
    }

    //TODO make a method, serving GET "/persons" request, which creates a list of Person objects, inserts them into
    // the templated called persons and renders them with <ul> <li> tags

    @GetMapping("/persons")
    public String getPersons(Model model) {
        model.addAttribute("personList", persons);
        return "persons-template";
    }

    @GetMapping("/persons-json")
    @ResponseBody
    public List<Person> getPersonsJson(Model model) {
        return persons;
    }

    List<Person> persons = List.of(
            new Person("Vasya", "Vasin"),
            new Person("Petya", "Petin"),
            new Person("Ivan", "Ivanov")
    );
}
