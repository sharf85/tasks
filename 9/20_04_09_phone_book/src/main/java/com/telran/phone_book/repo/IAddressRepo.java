package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;

import java.util.List;

public interface IAddressRepo {
    void add(Address address);

    void edit(Address address);

    Contact remove(int id);

    boolean remove(Address address);

    Contact find(int id);

    List<Address> findAllByContact(int id);
}
