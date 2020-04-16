package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.entity.Person;
import com.telran.person.persistence.PersonRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static final String PERSON_NOT_FOUND = "Person not found";
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

    public void removeById(int id) {
        personRepo.deleteById(id);
    }

    public PersonDto getById(int id) {
        Person person = personRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        return new PersonDto(person.getId(), person.getName(), person.getLastName(), person.getBirthday());
    }

    public void edit(PersonDto personDto) {
        Person person = personRepo.findById(personDto.id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));

        person.setName(personDto.firstName);
        person.setLastName(personDto.lastName);
        person.setBirthday(personDto.birthday);

        personRepo.save(person);
    }

    public List<PersonDto> filterByAge(int min, int max) {
        LocalDate now = LocalDate.now();
        LocalDate earliestBirthday = now.minusYears(max);
        LocalDate latestBirthday = now.minusYears(min);

        return personRepo.findByBirthdayAfterAndBirthdayBefore(earliestBirthday, latestBirthday).stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthday()
                ))
                .collect(Collectors.toList());
    }
}
