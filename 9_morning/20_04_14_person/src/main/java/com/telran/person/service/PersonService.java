package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import com.telran.person.persistence.IPersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final String PERSON_NOT_FOUND = "Person not found";
    final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(PersonDto personDto) {
        Person person = new Person(personDto.firstName, personDto.lastName, personDto.age);
        personRepository.save(person);
    }

    public void edit(PersonDto personDto) {
        Person person = personRepository.findById(personDto.id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));

        person.setName(personDto.firstName);
        person.setLastName(personDto.lastName);
        person.setAge(personDto.age);

        personRepository.save(person);
    }

    public PersonDto getById(int id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        return new PersonDto(id, person.getName(), person.getLastName(), person.getAge());
    }

    public void removeById(int id) {
        personRepository.deleteById(id);
    }


    public List<PersonDto> getAll() {
        List<Person> persons = personRepository.findAll();

        return persons.stream()
                .map(person -> new PersonDto(person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getAge()))
                .collect(Collectors.toList());

    }

    public List<PersonDto> getAllByName(String name) {
        List<Person> persons = personRepository.findByName(name);

        return persons.stream()
                .map(person -> new PersonDto(person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getAge()))
                .collect(Collectors.toList());

    }


    public List<PersonDto> getAllConstrainedByAge(int min, int max) {
        List<Person> persons = personRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(min, max);

        return persons.stream()
                .map(person -> new PersonDto(person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getAge()))
                .collect(Collectors.toList());

    }
}
