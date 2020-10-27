package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * An instance of the class stores Person objects
 */
public interface IPersonRepo extends CrudRepository<Person, Integer> {
    Collection<Person> findAll();

    // select * from person p where p.name like `Vasya`

    Collection<Person> findAllByName(String name);

    // make a method which fetches all the persons with the age grater than something

    Collection<Person> findAllByAgeGreaterThanEqualAndAgeLessThanEqual(int after, int before);

    Collection<Person> findAllByAgeBetween(int after, int before);

//    @Query("select p from Person p where p.age>=?1 and p.age<=?2")
//    Collection<Person> findAllByAgeBeforeTwoValues(int after, int before);

    @Query("select p from Person p where p.age>=:after and p.age<=:before")
    Collection<Person> findAllByAgeBetweenTwoValues(@Param("after") int after, @Param("before") int before);

    Collection<Person> findAllBySecondNameIgnoreCaseContaining(String pattern);
}
