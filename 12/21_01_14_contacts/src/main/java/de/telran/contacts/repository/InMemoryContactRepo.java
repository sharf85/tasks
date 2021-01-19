package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// AND TESTS!!!
@Repository
public class InMemoryContactRepo implements IContactRepo {

    Map<Integer, Contact> source = new HashMap<>();
    int lastUsedId;

    @Override
    public void save(Contact contact) {
        int id = contact.getId();

        if (id == 0) {
            contact.setId(++lastUsedId);
            source.put(lastUsedId, contact);
        } else if (source.containsKey(id)) {
            source.put(id, contact);
        } else {
            throw new ContactNotFoundException();
        }
    }

    @Override
    public Contact find(int id) {
        return source.get(id);
    }

    @Override
    public Contact remove(int id) {
        return source.remove(id);
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(source.values());
    }
}
