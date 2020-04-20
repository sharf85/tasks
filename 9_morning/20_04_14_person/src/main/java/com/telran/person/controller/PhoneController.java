package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.model.PhoneNumber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

//    NumberService numberService;

    //TODO add number to a person, edit number, remove number, all person's numbers, get by id
    @PostMapping("/number")
    public void create(@RequestBody NumberDto numberDto){

    }

}
