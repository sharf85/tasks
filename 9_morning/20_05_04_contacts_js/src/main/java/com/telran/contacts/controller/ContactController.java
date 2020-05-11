package com.telran.contacts.controller;

import com.telran.contacts.dto.Contact;
import com.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> contactForm() {
        return contactService.getAll();
    }

    @PostMapping("/contact")
    @ResponseBody
    public void addContact(@RequestBody Contact contact) {
        contactService.add(contact);
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

    @GetMapping("/")
    public String home() {
        return "forward:/contacts";
    }

    @GetMapping("/contacts")
    public String getContacts() {
        return "contacts";
    }

}
