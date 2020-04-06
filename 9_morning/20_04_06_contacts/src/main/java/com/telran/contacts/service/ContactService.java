package com.telran.contacts.service;

import com.telran.contacts.dto.Contact;
import com.telran.contacts.repository.IContactRepo;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void add(Contact contact) {
        contactRepo.add(contact);
    }

    public Contact get(int id) {
        return contactRepo.get(id);
    }
}
