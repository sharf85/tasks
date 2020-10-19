package de.telran.person.repo;

import de.telran.person.model.Person;

import java.util.List;

public interface IPersonRepo {

    public void save(Person person);

    public Person find(int id);

    public Person remove(int id);

    public List<Person> findAll();

}
