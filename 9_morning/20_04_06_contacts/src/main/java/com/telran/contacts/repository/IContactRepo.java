package com.telran.contacts.repository;

import com.telran.contacts.dto.Contact;

import java.util.List;

public interface IContactRepo {

    void add(Contact contact);

    Contact get(int id);

    void edit(Contact contact);

    Contact remove(int id);

    boolean remove(Contact contact);

    List<Contact> getAll();
}
