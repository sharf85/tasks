package com.telran.contacts.controller;

import com.telran.contacts.dto.Contact;
import com.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@CrossOrigin
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    @PostMapping("/contact")
    @ResponseBody
    public void newContact(@RequestBody Contact contact) {
        contactService.create(contact);
    }

    @PutMapping("/contact")
    @ResponseBody
    public void editContact(@RequestBody Contact contact) {
        contactService.edit(contact);
    }

    @DeleteMapping("/contact/{id}")
    @ResponseBody
    public void removeContact(@PathVariable int id) {
        contactService.remove(id);
    }

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("forward:contacts");
    }

}
