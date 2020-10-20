package de.telran.person.repo;

import de.telran.person.model.Person;

import java.util.List;

/**
 * An instance of the class stores Person objects
 */
public interface IPersonRepo {

    public void save(Person person);

    public Person find(int id);

    public Person remove(int id);

    public List<Person> findAll();

}
