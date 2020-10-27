package de.telran.person.repo;

import de.telran.person.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IPersonRepoIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IPersonRepo personRepo;

    @Test
    public void testFindAllByName_onePerson_existing() {
        Person person = new Person("Vasily");
        person.setAge(20);
        person.setSecondName("Vasin");

        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByName("Vasily");

        assertEquals(1, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();

        assertEquals(person.getAge(), personFromDb.getAge());
        assertEquals(person.getName(), personFromDb.getName());
        assertEquals(person.getSecondName(), personFromDb.getSecondName());

        assertTrue(personFromDb.getId() > 0);
    }
}
