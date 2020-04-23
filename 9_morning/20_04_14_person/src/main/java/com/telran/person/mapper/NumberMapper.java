package com.telran.person.mapper;

import com.telran.person.dto.NumberDto;
import com.telran.person.model.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class NumberMapper {

    public NumberDto mapNumberToDto(PhoneNumber number) {
        return new NumberDto(number.getId(), number.getNumber(), number.getPerson().getId());
    }
}
