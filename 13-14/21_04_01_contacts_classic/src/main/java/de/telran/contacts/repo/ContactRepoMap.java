package de.telran.contacts.repo;

import de.telran.contacts.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContactRepoMap implements IContactRepo {

    private final HashMap<Integer, Contact> contactById = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger();

    @Override
    public void save(Contact contact) {
        if (contact.getId() == 0) {
            contact.setId(currentId.incrementAndGet());
        } else if (!contactById.containsKey(contact.getId()))
            throw new NoSuchElementException();

        contactById.put(contact.getId(), contact);
    }

    @Override
    public Contact find(int id) {
        return contactById.get(id);
    }

    @Override
    public Contact remove(int id) {
        return contactById.remove(id);
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contactById.values());
    }
}
