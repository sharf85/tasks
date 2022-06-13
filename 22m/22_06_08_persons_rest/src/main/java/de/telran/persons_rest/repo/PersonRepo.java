package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    public List<Person> findAllByName(String name);
}
