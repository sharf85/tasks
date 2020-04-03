package com.telran.contacts.repo;

import com.telran.contacts.dto.Contact;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

    }

    @Override
    public Contact get(int id) {
        return source.get(id);
    }

    @Override
    public Contact remove(int id) {
        return null;
    }
}
