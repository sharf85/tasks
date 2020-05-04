package com.telran.contacts.repo;

import com.telran.contacts.dto.Contact;

import java.util.List;

public interface IContactRepo {

    void add(Contact contact);

    void edit(Contact contact);

    Contact get(int id);

    Contact remove(int id);

    List<Contact> getAll();
}
