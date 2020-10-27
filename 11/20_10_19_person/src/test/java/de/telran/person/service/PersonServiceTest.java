package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    IPersonRepo personRepo;

    @InjectMocks
    PersonService personService;

    // The same as above
//    @BeforeEach
//    public void init() {
//        personRepo = mock(IPersonRepo.class);
//        personService = new PersonService(personRepo);
//    }

    @Test
    public void testCreate_realData_newPerson() {
//        doAnswer(invocation -> {
//            Person person = (Person) invocation.getArguments()[0];
//            person.setId(10);
//            return null;
//        }).when(personRepo).save(any(Person.class));

        String name = "name";
        String secondName = "secondName";
        int age = 20;

        Person createdPerson = personService.create(name, secondName, age);
        assertEquals(name, createdPerson.getName());
        assertEquals(secondName, createdPerson.getSecondName());
        assertEquals(age, createdPerson.getAge());

        verify(personRepo, times(1)).save(argThat(argument -> argument == createdPerson));
    }

    @Test
    void testGetPerson_exist() {
        Person person = new Person("Name");
        person.setAge(20);
        person.setSecondName("Second");

        when(personRepo.findById(15)).thenReturn(Optional.of(person));
        assertEquals(person, personService.get(15));
    }

    @Test
    void testGetPerson_notExist_throwsPersonNotFoundException() {
        assertThrows(EntityNotFoundException.class, () -> personService.get(17));
    }

    @Test
    void testGetAll() {
        Person person1 = new Person("Name");
        person1.setSecondName("First");
        person1.setAge(30);

        Person person2 = new Person("Name");
        person1.setSecondName("Second");
        person1.setAge(30);

        Person person3 = new Person("Name");
        person1.setSecondName("Third");
        person1.setAge(30);

        when(personRepo.findAll()).thenReturn(Arrays.asList(person1, person2, person3));
        assertEquals(Arrays.asList(person1, person2, person3), personService.getAll());
    }

    @Test
    void testRemovePerson_1el_exist() {
        Person person1 = new Person("Name");
        person1.setSecondName("First");
        person1.setAge(30);

        when(personRepo.findById(17)).thenReturn(Optional.of(person1));
        assertEquals(person1, personService.remove(17));
        verify(personRepo, times(1)).delete(person1);
    }

    @Test
    void testRemovePerson_notExist_throwsPersonNotFoundException() {
        assertThrows(EntityNotFoundException.class, () -> personService.remove(17));
    }

    @Test
    public void testEdit_notExist_throwsPersonNotFoundException() {
        assertThrows(EntityNotFoundException.class, () -> personService.edit(0, "some", "second", 25));
    }

    @Test
    public void testEdit_Exist_changes() {
        Person person1 = new Person("Name");
        person1.setSecondName("First");
        person1.setAge(30);

        personService = spy(personService);
        doReturn(person1).when(personService).get(12);

        personService.edit(12, "Another", "Second", 31);

        verify(personRepo, times(1)).save(argThat(personToSave ->
                personToSave.getName().equals("Another") &&
                        personToSave.getSecondName().equals("Second") &&
                        personToSave.getAge() == 31
        ));
    }

}
