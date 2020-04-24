package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.dto.PersonDto;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.model.Person;
import com.telran.person.persistence.INumberRepository;
import com.telran.person.persistence.IPersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    IPersonRepository personRepository;

    @Mock
    INumberRepository numberRepository;

    @Mock
    PersonMapper personMapper;

    @Mock
    NumberMapper numberMapper;

    @InjectMocks
    PersonService personService;

    @Test
    public void testAdd_personWithoutNumbers_passesToRepo() {
        LocalDate birthday = LocalDate.now().minusYears(25);

        PersonDto personIn = new PersonDto(5, "Vasya", "Vasin", birthday);

        personService.add(personIn);

        verify(personRepository, times(1)).save(any());
        verify(personRepository, times(1)).save(argThat(person ->
//                person.getId() == 0
                        person.getLastName().equals(personIn.lastName)
                                && person.getName().equals(personIn.firstName)
                                && birthday.equals(person.getBirthday())
        ));

        verify(numberRepository, never()).save(any());
    }

    @Captor
    ArgumentCaptor<Person> personCaptor;

    @Test
    public void testAdd_personWithNumbers_1NumberSaved() {
        LocalDate birthday = LocalDate.now().minusYears(25);
        PersonDto personIn = new PersonDto(0, "Vasya", "Vasin", birthday);
        personIn.numbers = Arrays.asList(new NumberDto(0, "number1", 0));

        personService.add(personIn);
//here we catch all the persons that were as arguments while invoking personRepository.save(person)
        verify(personRepository).save(personCaptor.capture());

        List<Person> capturedPersons = personCaptor.getAllValues();
        assertEquals(1, capturedPersons.size());
        Person capturedPerson = capturedPersons.get(0);
//check the single captured person
        assertEquals(personIn.firstName, capturedPerson.getName());
        assertEquals(personIn.lastName, capturedPerson.getLastName());
        assertEquals(birthday, capturedPerson.getBirthday());

//check the single captured number
        verify(numberRepository, times(1)).save(any());
        verify(numberRepository, times(1)).save(argThat(
                number -> number.getNumber().equals("number1") &&
                        number.getPerson().equals(capturedPerson)
                )
        );
    }

}