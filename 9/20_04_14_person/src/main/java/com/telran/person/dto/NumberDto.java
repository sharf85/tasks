package com.telran.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
public class NumberDto {
    //for aside builder
//    NumberDto(int id, String number, int personId) {
//        this.id = id;
//        this.number = number;
//        this.personId = personId;
//    }

    public int id;

    public String number;

    public int personId;
}
