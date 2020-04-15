package com.telran.person.persistence;

import com.telran.person.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person, Integer> {

    public List<Person> findByName(String name);

    public List<Person> findAll();
}
