package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.entity.Person;
import com.telran.person.persistence.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public void create(PersonDto personDto) {
        Person person = new Person(personDto.firstName, personDto.lastName, personDto.birthday);
        personRepo.save(person);
    }

    public List<PersonDto> getAll() {
        return personRepo.findAll().stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthday()
                ))
                .collect(Collectors.toList());
    }

    public List<PersonDto> getByName(String firstName) {
        return personRepo.findByName(firstName).stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthday()
                ))
                .collect(Collectors.toList());
    }
}
