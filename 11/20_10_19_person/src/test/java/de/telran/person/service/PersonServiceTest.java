package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    IPersonRepo personRepo;

    PersonService personService;

    // The same as above
    @BeforeEach
    public void init() {
        personRepo = mock(IPersonRepo.class);
        personService = new PersonService(personRepo);
    }

    @Test
    public void testCreate_realData_newPerson() {
        doAnswer(invocation -> {
            Person person = (Person) invocation.getArguments()[0];
            person.setId(10);
            return null;
        }).when(personRepo).save(any(Person.class));

        String name = "name";
        String secondName = "secondName";
        int age = 20;

        Person createdPerson = personService.create(name, secondName, age);
        assertEquals(name, createdPerson.getName());
        assertEquals(secondName, createdPerson.getSecondName());
        assertEquals(age, createdPerson.getAge());
        //not necessary
        assertNotEquals(0, createdPerson.getId());

        verify(personRepo, times(1)).save(argThat(argument -> argument == createdPerson));
    }
}
