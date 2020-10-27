package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private static final String PERSON_NOT_FOUND = "Person not found";
    private final IPersonRepo personRepo;

    public PersonService(@Autowired IPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person create(String name, String secondName, int age) {
        Person person = new Person(name);
        person.setAge(age);
        person.setSecondName(secondName);

        // repo sets the id of the person
        personRepo.save(person);
        return person;
    }

    public void edit(int id, String name, String secondName, int age) {
        Person person = get(id);

        person.setSecondName(secondName);
        person.setName(name);
        person.setAge(age);

        personRepo.save(person);
    }

    public Person remove(int id) {
        Person person = get(id);
        personRepo.delete(person);

        return person;
    }

    public Person get(int id) {
        return personRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
    }

    public List<Person> getAll() {
        return new ArrayList<>(personRepo.findAll());
    }

    public List<Person> getAllByName(String name) {
        return new ArrayList<>(personRepo.findAllByName(name));
    }

    public List<Person> getAllByAgeBetween(int after, int before) {
        return new ArrayList<>(personRepo.findAllByAgeBetweenTwoValues(after, before));
    }

    public List<Person> getAllBySecondNameContainingPattern(String pattern) {
        return new ArrayList<>(personRepo.findAllBySecondNameIgnoreCaseContaining(pattern));
    }
}
