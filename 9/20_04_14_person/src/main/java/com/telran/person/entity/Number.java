package com.telran.person.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
//TODO lombokize this
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;

    public Number() {
    }

    public Number(Person person, String number) {
        this.person = person;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }
}
