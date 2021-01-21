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
    public String editContactForm(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("contact/save")
    public String saveContact(@ModelAttribute Contact contact) {
        if (contact.getId() > 0)
            contactService.edit(contact);
        else
            contactService.create(contact);

        return "redirect:/contacts";
    }

    /**
     * the endpoint should delete the contact and redirect to the contacts page
     */
    @GetMapping("contacts/{id}/delete")
    public String deleteContact(@PathVariable int id) {
        contactService.remove(id);
        return "redirect:/contacts";
    }

    @GetMapping()
    public String home() {
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/{id}")
    public String getContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact";
    }

}
