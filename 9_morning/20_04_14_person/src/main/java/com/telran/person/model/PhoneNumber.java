package com.telran.person.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Person person;

    public PhoneNumber() {
    }

    public PhoneNumber(String number, Person person) {
        this.number = number;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
