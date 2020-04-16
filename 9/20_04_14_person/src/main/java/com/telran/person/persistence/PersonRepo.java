package com.telran.person.persistence;

import com.telran.person.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepo extends CrudRepository<Person, Integer> {

    List<Person> findByName(String name);

    List<Person> findAll();

    List<Person> findByBirthdayAfterAndBirthdayBefore(LocalDate earliestBirthday, LocalDate latestBirthday);
}
