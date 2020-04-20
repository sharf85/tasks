package com.telran.person.persistence;

import com.telran.person.entity.Number;
import org.springframework.data.repository.CrudRepository;

public interface NumberRepo extends CrudRepository<Number, Integer> {
}
