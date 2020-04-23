package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.model.Person;
import com.telran.person.model.PhoneNumber;
import com.telran.person.persistence.INumberRepository;
import com.telran.person.persistence.IPersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

//TODO while implementation use NumberMapper
@Service
public class NumberService {

    static final String NUMBER_NOT_FOUND = "Number not found";

    final IPersonRepository personRepository;
    final INumberRepository numberRepository;
    final NumberMapper numberMapper;

    public NumberService(IPersonRepository personRepository, INumberRepository numberRepository, NumberMapper numberMapper) {
        this.personRepository = personRepository;
        this.numberRepository = numberRepository;
        this.numberMapper = numberMapper;
    }

    public void create(NumberDto numberDto) {
        Person person = personRepository.findById(numberDto.personId).orElseThrow(() -> new EntityNotFoundException(PersonService.PERSON_NOT_FOUND));
        PhoneNumber number = new PhoneNumber(numberDto.number, person);
        numberRepository.save(number);
    }

    public NumberDto getById(int id) {
        PhoneNumber number = numberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NUMBER_NOT_FOUND));
        return numberMapper.mapNumberToDto(number);
    }

    public void edit(NumberDto numberDto) {
        PhoneNumber number = numberRepository.findById(numberDto.id).orElseThrow(() -> new EntityNotFoundException(NUMBER_NOT_FOUND));

        number.setNumber(numberDto.number);
        numberRepository.save(number);
    }

    public void removeById(int id) {
        numberRepository.deleteById(id);
    }

    public List<NumberDto> getByPersonId(int personId) {
        return numberRepository.findByPersonId(personId).stream()
                .map(numberMapper::mapNumberToDto)
                .collect(Collectors.toList());
    }
}
