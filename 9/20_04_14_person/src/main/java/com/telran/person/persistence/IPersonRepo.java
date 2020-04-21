package com.telran.person.persistence;

import com.telran.person.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPersonRepo extends CrudRepository<Person, Integer> {

    List<Person> findByName(String name);

    List<Person> findAll();

    List<Person> findByBirthdayBetween(LocalDate earliestBirthday, LocalDate latestBirthday);

//    @Query("select p from Person p where p.birthday>=?1 and p.birthday<=?2")
//    List<Person> findByBirthdayBetweenCustom(LocalDate earliestBirthday, LocalDate latestBirthday);

    @Query("select p from Person p where p.birthday>=:lower and p.birthday<=:upper")
    List<Person> findByBirthdayBetweenCustom(
            @Param("lower") LocalDate earliestBirthday,
            @Param("upper") LocalDate latestBirthday);

    @Modifying
    @Query("delete from Person p where p.birthday<?1")
    public void removeTooYoung(LocalDate upperBound);
}
