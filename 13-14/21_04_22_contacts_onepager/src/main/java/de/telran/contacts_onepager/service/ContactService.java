package de.telran.contacts_onepager.service;

import de.telran.contacts_onepager.entity.Contact;
import de.telran.contacts_onepager.repo.IContactRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

// the domain logic lies here.
@Service
public class ContactService {

    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getAll() {
        Iterable<Contact> contacts = contactRepo.findAll();

        List<Contact> res = new ArrayList<>();
        for (Contact contact : contacts) {
            res.add(contact);
        }

        return res;
    }

    public Contact get(int id) {
        return contactRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        Contact res = get(id);
        contactRepo.deleteById(id);
        return res;
    }

    public List<Contact> searchByNameOrLastName(String pattern) {
//        return new ArrayList<>(contactRepo.findAllContainingPattern(pattern));
        return new ArrayList<>(contactRepo.findAllByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(pattern, pattern));
    }

    // TODO create a method which will be searching contacts by a pattern
}
