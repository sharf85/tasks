package de.telran.person.service;

import de.telran.person.exception.PersonNotFoundException;
import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Person person = personRepo.remove(id);

        if (person == null)
            throw new PersonNotFoundException(PERSON_NOT_FOUND);

        return person;
    }

    public Person get(int id) {
        Person person = personRepo.find(id);

        if (person == null)
            throw new PersonNotFoundException(PERSON_NOT_FOUND);

        return person;
    }

    public List<Person> getAll() {
        return personRepo.findAll();
    }
}
