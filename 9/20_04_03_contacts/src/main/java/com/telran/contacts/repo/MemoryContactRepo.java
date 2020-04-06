package com.telran.contacts.repo;

import com.telran.contacts.dto.Contact;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemoryContactRepo implements IContactRepo {

    Map<Integer, Contact> source = new HashMap<>();
    private AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(Contact contact) {
        source.put(currentId.incrementAndGet(), contact);
        contact.setId(currentId.get());
    }

    @Override
    public void edit(Contact contact) {
        source.replace(contact.getId(), contact);
    }

    @Override
    public Contact get(int id) {
        return source.get(id);
    }

    @Override
    public Contact remove(int id) {
        return source.remove(id);
    }

    @Override
    public List<Contact> getAll() {
        return source
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Contact::getId))
                .collect(Collectors.toList());
    }
}
