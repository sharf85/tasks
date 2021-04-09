package de.telran.contacts.repo;

import de.telran.contacts.entity.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactRepoList implements IContactRepo {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final AtomicInteger currentId = new AtomicInteger();

    @Override
    public void save(Contact contact) {
        if (contact.getId() == 0) {
            contact.setId(currentId.incrementAndGet());
            contacts.add(contact);
        } else {
            Contact oldContact = find(contact.getId());
            oldContact.setName(contact.getName());
            oldContact.setLastName(contact.getLastName());
            oldContact.setAge(contact.getAge());
        }
    }

    @Override
    public Contact find(int id) {
        return contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Contact remove(int id) {
        Contact res = find(id);
        contacts.remove(res);
        return res;
    }

    @Override
    public List<Contact> findAll() {
        return Collections.unmodifiableList(contacts);
    }
}
