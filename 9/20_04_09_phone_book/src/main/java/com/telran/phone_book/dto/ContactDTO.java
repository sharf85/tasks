package com.telran.phone_book.dto;

import java.time.LocalDate;
import java.util.List;

public class ContactDTO {
    public int id;
    public String name;
    public String lastName;
    public LocalDate date;

    public List<AddressDTO> addresses;
    public List<PhoneNumberDTO> numbers;
}
