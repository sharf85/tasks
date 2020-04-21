package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.entity.Number;
import com.telran.person.entity.Person;
import com.telran.person.persistence.INumberRepo;
import com.telran.person.persistence.IPersonRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class NumberService {

    final private INumberRepo numberRepo;
    final private IPersonRepo personRepo;

    public NumberService(INumberRepo numberRepo, IPersonRepo personRepo) {
        this.numberRepo = numberRepo;
        this.personRepo = personRepo;
    }

    public void create(NumberDto numberIn) {
        Person person = personRepo.findById(numberIn.personId).orElseThrow(() -> new EntityNotFoundException(PersonService.PERSON_NOT_FOUND));
        Number number = new Number(person, numberIn.number);
        numberRepo.save(number);
    }

    //TODO edit, create, removeById, getAllByPerson
}
