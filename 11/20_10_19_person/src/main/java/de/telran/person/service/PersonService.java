package de.telran.person.service;

import de.telran.person.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person create(String name, String secondName, int age) {
        Person person = new Person(name);
        person.setAge(age);
        person.setSecondName(secondName);
        return person;
    }
}
