package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;
import com.telran.phone_book.repo.IAddressRepo;
import com.telran.phone_book.repo.IContactRepo;
import com.telran.phone_book.repo.IPhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    IContactRepo contactRepo;
    IAddressRepo addressRepo;
    IPhoneNumberRepo numberRepo;

    public ContactDTO getContact(int id) {
        Contact contact = contactRepo.find(id);
        List<Address> addresses = addressRepo.findAllByContact(id);
        List<PhoneNumber> numbers = numberRepo.findAllByContact(id);

        ContactDTO contactOut = new ContactDTO();
//      TODO  move contact data to contactDTO data

        contactOut.addresses = addresses.stream()
                .map(address -> {
                    AddressDTO res = new AddressDTO();
//      TODO move data from address data to addressDTO data
                    return res;
                })
                .collect(Collectors.toList());

        contactOut.numbers = numbers.stream()
                .map(address -> {
                    PhoneNumberDTO res = new PhoneNumberDTO();
//      TODO move data from number data to numberDTO data
                    return res;
                })
                .collect(Collectors.toList());

        return contactOut;
    }
}
