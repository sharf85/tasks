package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.persistence.INumberRepository;
import com.telran.person.persistence.IPersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

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
    public void testAdd_normalData_passesToRepo() {
        LocalDate birthday = LocalDate.now().minusYears(25);

        PersonDto personIn = new PersonDto(5, "Vasya", "Vasin", LocalDate.now().minusYears(25));

        personService.add(personIn);

        verify(personRepository).save(argThat(person ->
                person.getId() == 0
                        && person.getLastName().equals(personIn.lastName)
                        && person.getName().equals(personIn.firstName)
                        && birthday.equals(person.getBirthday())

        ));
    }

    @Test
    public void testAdd_normalDataWithNumbers_passesToRepo() {
        LocalDate birthday = LocalDate.now().minusYears(25);

        PersonDto personIn = new PersonDto(5, "Vasya", "Vasin", LocalDate.now().minusYears(25));

        personService.add(personIn);

        verify(personRepository).save(argThat(person ->
                person.getId() == 0
                        && person.getLastName().equals(personIn.lastName)
                        && person.getName().equals(personIn.firstName)
                        && birthday.equals(person.getBirthday())
        ));
    }

}