package com.telran.contacts.repository;

import com.telran.contacts.dto.Contact;

import java.util.List;

public interface IContactRepo {

    public void add(Contact contact);

    public Contact get(int id);

    public void edit(Contact contact);

    public Contact remove(int id);

    public boolean remove(Contact contact);

    public List<Contact> getAll();
}
