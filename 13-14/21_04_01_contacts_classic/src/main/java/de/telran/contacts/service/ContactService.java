package de.telran.contacts.service;

import de.telran.contacts.entity.Contact;
import de.telran.contacts.repo.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

// the domain logic lies here.
@Service
public class ContactService {

    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    public Contact get(int id) {
        return contactRepo.find(id);
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        return contactRepo.remove(id);
    }
}
