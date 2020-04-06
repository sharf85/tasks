package com.telran.contacts.service;

import com.telran.contacts.dto.Contact;
import com.telran.contacts.repo.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void create(Contact contact) {
        contactRepo.add(contact);
    }

    public Contact get(int id) {
        return contactRepo.get(id);
    }

    public void edit(Contact contact) {
        contactRepo.edit(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.getAll();
    }

    public void remove(int id) {
        contactRepo.remove(id);
    }
}
