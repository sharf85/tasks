package de.telran.hellowebworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello-mvc/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name, Model model) {
        model.addAttribute("helloText", "Hello, " + name);
        return "hello-mvc";
    }

    //    @RequestMapping(value = "/hello-simple/{name}", method = RequestMethod.GET)
    @GetMapping(value = "/hello-simple/{name}")
    @ResponseBody
    public String helloSimpleText(@PathVariable String name) {
        return "Hello simply, " + name;
    }

    @RequestMapping(value = "/hello-json/{name}", method = RequestMethod.GET)
    @ResponseBody
    public JsonName helloJsonText(@PathVariable String name) {
        JsonName jsonName = new JsonName(name);
        return jsonName;
    }

    @RequestMapping(value = "/hello-json", method = RequestMethod.POST)
//    @PostMapping("/hello-json")
    @ResponseBody
    public JsonName helloJsonText(@RequestBody JsonName incomingData) {
        incomingData.name = "Hello, " + incomingData.name;
        return incomingData;
    }
}
