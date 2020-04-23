package com.telran.person.persistence;

import com.telran.person.entity.Number;
import com.telran.person.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface INumberRepo extends CrudRepository<Number, Integer> {
    List<Number> getByPerson(Person person);

    List<Number> findByPersonId(int id);
}
