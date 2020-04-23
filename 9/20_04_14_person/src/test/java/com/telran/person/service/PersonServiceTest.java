package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.entity.Person;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.persistence.INumberRepo;
import com.telran.person.persistence.IPersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private IPersonRepo personRepo;
    @Mock
    private INumberRepo numberRepo;
    @Mock
    private PersonMapper personMapper;
    @Mock
    private NumberMapper numberMapper;

    @InjectMocks
    PersonService personService;

    @Captor
    ArgumentCaptor<Person> personCaptor;

    @Test
    public void testCreate_personWithoutNumbers_success() {
        LocalDate birthday = LocalDate.now().minusYears(11);
        PersonDto personDto = new PersonDto(5, "Vasily", "Kotov", birthday);

        personService.create(personDto);

//        verify(personRepo).save(argThat(person ->
//                person.getName().equals(personDto.firstName) &&
//                        person.getLastName().equals(personDto.lastName) &&
//                        person.getBirthday().equals(birthday)
//        ));

        verify(personRepo).save(personCaptor.capture());

        Person capturedPerson = personCaptor.getValue();

        System.out.println(capturedPerson);
    }
}