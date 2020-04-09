package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;

import java.util.List;

public interface IPhoneNumberRepo {

    void add(PhoneNumber phoneNumber);

    void edit(PhoneNumber phoneNumber);

    Contact remove(int id);

    boolean remove(PhoneNumber phoneNumber);

    Contact find(int id);

    List<PhoneNumber> findAllByCodePlusNumber(String pattern);

    List<PhoneNumber> findAllByContact(int id);
}
