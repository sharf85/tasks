package de.telran.contacts.controller;

import de.telran.contacts.model.Contact;
import de.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    ContactService contactService;

    @GetMapping("contacts")
    public String getAll(Model model) {
        List<Contact> contacts = contactService.getAll();

        model.addAttribute("contactList", contacts);
        return "contacts";
    }

    @GetMapping("contacts/add")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @GetMapping("contacts/{id}/edit")
    public String editContactForm(@PathVariable String id, Model model) {
        //TODO 1. get the contact by the specified id by the service
        //TODO 2. insert the contact to the model in order to show the contact in the contact-form template


        return "contact-form";
    }

    @PostMapping("contact/save")
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.create(contact);
        return "redirect:/contacts";
    }

    /**
     * the endpoint should delete the contact and redirect to the contacts page
     */
    @GetMapping("contacts/{id}/delete")
    public String deleteContact(@PathVariable String id) {
        //TODO 1. remove the contact via contactService
        //TODO 2. redirect to the contacts page after the deletion
        return "";
    }

}
