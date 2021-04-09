package de.telran.contacts.repo;

import de.telran.contacts.entity.Contact;

import java.util.List;

// The repo layer is responsible for storing data
//TODO: implement this via List and via HashMap
public interface IContactRepo {

    void save(Contact contact);

    Contact find(int id);

    Contact remove(int id);

    List<Contact> findAll();
}
