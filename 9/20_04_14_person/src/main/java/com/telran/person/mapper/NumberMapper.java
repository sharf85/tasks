package com.telran.person.mapper;

import com.telran.person.dto.NumberDto;
import com.telran.person.entity.Number;
import org.springframework.stereotype.Component;

@Component
public class NumberMapper {
    public NumberDto mapNumberToDto(Number number) {
        return new NumberDto(/*TODO complete*/);
    }
}
