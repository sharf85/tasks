package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Contact;

import java.util.List;

public interface IContactRepo {
    void add(Contact contact);

    void edit(Contact contact);

    Contact remove(int id);

    boolean remove(Contact contact);

    Contact find(int id);

    List<Contact> findAllByName(String pattern);

    List<Contact> findAllByLastName(String pattern);
}
