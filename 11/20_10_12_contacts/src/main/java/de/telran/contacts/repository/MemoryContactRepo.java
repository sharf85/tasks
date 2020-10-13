package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//TODO implement and write tests
@Repository
public class MemoryContactRepo implements IContactRepo {

    private final List<Contact> source = new ArrayList<>();
    private final AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(Contact contact) {
        contact.id = currentId.incrementAndGet();
        source.add(contact);
    }

    @Override
    public Contact getById(int id) {
        return source.stream()
                .filter(contact -> contact.id == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void edit(Contact contact) {
        Contact oldContact = getById(contact.id);

        if (oldContact == null)
            return;

        oldContact.name = contact.name;
        oldContact.number = contact.number;
    }

    @Override
    public List<Contact> getAll() {
        return Collections.unmodifiableList(source);
    }

    @Override
    public void remove(int id) {
        source.removeIf(contact -> contact.id == id);
    }
}
