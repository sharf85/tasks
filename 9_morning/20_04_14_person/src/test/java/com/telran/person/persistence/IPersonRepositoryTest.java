package com.telran.person.persistence;

import com.telran.person.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class IPersonRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IPersonRepository personRepository;

    @Test
    public void testFindByName_oneRecord_found() {
        LocalDate kotusBirthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", LocalDate.now().minusYears(11));

        entityManager.persist(person);
        entityManager.flush();

        List<Person> foundPersons = personRepository.findByName("Vasya");
        assertEquals(1, foundPersons.size());

        assertEquals("Vasya", foundPersons.get(0).getName());
        assertEquals("Kotov", foundPersons.get(0).getLastName());
        assertEquals(kotusBirthday, foundPersons.get(0).getBirthday());
    }
}