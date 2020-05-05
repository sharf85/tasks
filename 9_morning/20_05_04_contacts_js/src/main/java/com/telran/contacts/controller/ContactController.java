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

//    @GetMapping("/contact")
//    public String contactForm(Model model) {
//        model.addAttribute("contact", new Contact());
//        return "contact-form";
//    }

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> contactForm() {
        return contactService.getAll();
    }

//    @PostMapping("/contact")
//    public String addContact(@RequestBody Contact contact) {
//        if (contact.getId() == 0)
//            contactService.add(contact);
//        else
//            contactService.edit(contact);
//        return "redirect:/";
//    }

    @PostMapping("/contact")
    @ResponseBody
    public void addContact(@RequestBody Contact contact) {
        contactService.add(contact);
    }

    @GetMapping("/")
    public String home() {
        return "forward:/contacts";
    }

    @GetMapping("/contact/{id}")
    public String getContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact";
    }

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/contact/edit/{id}")
    public String editContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

//    @GetMapping("/contact/remove/{id}")
//    public String removeContact(@PathVariable int id) {
//        contactService.remove(id);
//        return "redirect:/";
//    }

    //TODO use for remove contact
    @DeleteMapping("/contact/{id}")
    public void removeContact(@PathVariable int id) {
        contactService.remove(id);
    }
}
