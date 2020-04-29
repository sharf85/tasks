package com.telran.contacts.controller;

import com.telran.contacts.dto.Contact;
import com.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("contact")
    public String newContactFrom(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("contact")
    public ModelAndView newContact(@ModelAttribute Contact contact) {
        if (contact.getId() == 0)
            contactService.create(contact);
        else
            contactService.edit(contact);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("edit-contact/{id}")
    public String editContactForm(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @GetMapping("contact/{id}")
    public String getContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact";
    }

    @GetMapping("contacts")
    public String getContacts(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("forward:contacts");
    }

    @GetMapping("remove-contact/{id}")
    public ModelAndView removeContact(@PathVariable int id) {
        contactService.remove(id);
        return new ModelAndView("redirect:/");
    }
}
