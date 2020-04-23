package com.telran.person.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    public Number(Person person, String number) {
        this.person = person;
        this.number = number;
    }

}
