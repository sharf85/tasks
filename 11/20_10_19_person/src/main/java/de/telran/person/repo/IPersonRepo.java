package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * An instance of the class stores Person objects
 */
public interface IPersonRepo extends CrudRepository<Person, Integer> {
    Collection<Person> findAll();

    // select * from person p where p.name like `Vasya`

    Collection<Person> findAllByName(String name);

    // make a method which fetches all the persons with the age grater than something

    Collection<Person> findAllByAgeGreaterThanEqual(int from);
}
