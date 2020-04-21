package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.entity.Number;
import com.telran.person.entity.Person;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.persistence.INumberRepo;
import com.telran.person.persistence.IPersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    static final String PERSON_NOT_FOUND = "Person not found";

    final private IPersonRepo personRepo;
    final private INumberRepo numberRepo;
    final private PersonMapper personMapper;
    final private NumberMapper numberMapper;

    public PersonService(IPersonRepo personRepo, INumberRepo numberRepo, PersonMapper personMapper, NumberMapper numberMapper) {
        this.personRepo = personRepo;
        this.numberRepo = numberRepo;
        this.personMapper = personMapper;
        this.numberMapper = numberMapper;
    }

    public void create(PersonDto personDto) {
        Person person = new Person(personDto.firstName, personDto.lastName, personDto.birthday);
        personRepo.save(person);

        personDto.numbers.stream()
                .map(numberIn -> new Number(person, numberIn.number))
                .forEach(numberRepo::save);
    }

    public List<PersonDto> getAll() {
        return personRepo.findAll().stream()
                .map(personMapper::mapPersonToDto)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getByName(String firstName) {
        return personRepo.findByName(firstName).stream()
                .map(personMapper::mapPersonToDto)
                .collect(Collectors.toList());
    }

    public void removeById(int id) {
        personRepo.deleteById(id);
    }

    public PersonDto getById(int id) {
        Person person = personRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        PersonDto res = personMapper.mapPersonToDto(person);

        res.numbers = person.getNumbers().stream()
                .map(numberMapper::mapNumberToDto)
                .collect(Collectors.toList());
        return res;
    }

    @Transactional
    public void edit(PersonDto personDto) {
        Person person = personRepo.findById(personDto.id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));

        person.setName(personDto.firstName);
        person.setLastName(personDto.lastName);
        person.setBirthday(personDto.birthday);

//        personRepo.save(person);
    }

    public List<PersonDto> filterByAge(int min, int max) {
        LocalDate now = LocalDate.now();
        LocalDate earliestBirthday = now.minusYears(max);
        LocalDate latestBirthday = now.minusYears(min);

        return personRepo.findByBirthdayBetweenCustom(earliestBirthday, latestBirthday).stream()
                .map(personMapper::mapPersonToDto)
                .collect(Collectors.toList());
    }
}
