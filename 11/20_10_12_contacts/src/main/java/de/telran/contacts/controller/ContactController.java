package de.telran.contacts.controller;

import de.telran.contacts.model.Contact;
import de.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact/add")
    public String addContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    //TODO save the received contact
    @PostMapping("/contact/add")
    public String addContact(@ModelAttribute Contact contact, Model model) {
        model.addAttribute("contact", contact);
        return "contact-form";
    }
}
