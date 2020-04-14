package com.telran.person.persistence;

import com.telran.person.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Integer> {
    public List<Person> findByName(String name);


}
