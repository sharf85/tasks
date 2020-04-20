package com.telran.person.persistence;

import com.telran.person.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Integer> {

    public List<Person> findAll();

    public List<Person> findByName(String name);

//    public List<Person> findByAgeGreaterThanEqualAndAgeLessThanEqual(int min, int max);

    public List<Person> findByBirthdayBetween(LocalDate earliestBirthday, LocalDate latestBirthday);

    //    @Query("select p from Person p where p.birthday>=?1 and p.birthday<=?2")
//    public List<Person> findByBirthdayBetweenCustom(LocalDate after, LocalDate before);
    @Query("select p from Person p where p.birthday>=:after and p.birthday<=:before")
    public List<Person> findByBirthdayBetweenCustom(
            @Param("after") LocalDate after,
            @Param("before") LocalDate before);

    @Modifying
    @Query("delete from Person p where p.lastName like ?1%")
    public void removeWithLastnameStarting(String pattern);

}
