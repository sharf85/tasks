package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.model.Person;
import com.telran.person.model.PhoneNumber;
import com.telran.person.persistence.INumberRepository;
import com.telran.person.persistence.IPersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

//TODO while implementation use NumberMapper
@Service
public class NumberService {

    IPersonRepository personRepository;
    INumberRepository numberRepository;

    public NumberService(IPersonRepository personRepository, INumberRepository numberRepository) {
        this.personRepository = personRepository;
        this.numberRepository = numberRepository;
    }

    public void create(NumberDto numberDto) {
        Person person = personRepository.findById(numberDto.personId).orElseThrow(() -> new EntityNotFoundException(PersonService.PERSON_NOT_FOUND));
        PhoneNumber number = new PhoneNumber(numberDto.number, person);
        numberRepository.save(number);
    }
}
