package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoryPersonRepo implements IPersonRepo {

    @Override
    public void save(Person person) {

    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Person remove(int id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
