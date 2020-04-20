package com.telran.person.persistence;

import com.telran.person.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface INumberRepository extends CrudRepository<PhoneNumber, Integer> {
}
