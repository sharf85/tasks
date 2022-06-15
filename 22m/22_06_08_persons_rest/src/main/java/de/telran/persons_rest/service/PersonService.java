package de.telran.persons_rest.service;

import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Person get(int id) {
        return personRepo.findById(id).orElseThrow();
    }

    public List<Person> getAllByNameAndLastName(Optional<String> name, Optional<String> lastname) {
        if (name.isPresent() && lastname.isPresent()) {
            return personRepo.findAllByNameIgnoreCaseAndLastnameIgnoreCase(name.get(), lastname.get());
        } else if (name.isPresent()) {
            return personRepo.findAllByNameIgnoreCase(name.get());
        } else if (lastname.isPresent()) {
            return personRepo.findAllByLastnameIgnoreCase(lastname.get());
        }
        return personRepo.findAll();
    }
}
