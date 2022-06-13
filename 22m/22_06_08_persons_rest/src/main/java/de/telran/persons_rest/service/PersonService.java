package de.telran.persons_rest.service;

import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public Person remove(int id) {
        Person person = get(id);
        personRepo.delete(person);
        return person;
    }

    public List<Person> getAll() {
        return personRepo.findAll();
    }

    public Person get(int id) {
        return personRepo.findById(id).orElseThrow();
    }
}
