package com.telran.contacts.repo;

import com.telran.contacts.dto.Contact;

public interface IContactRepo {

    void add(Contact contact);

    void edit(Contact contact);

    Contact get(int id);

    Contact remove(int id);
}
