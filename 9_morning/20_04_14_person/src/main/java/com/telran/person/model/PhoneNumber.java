package com.telran.person.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String number;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Person person;

    public PhoneNumber(String number, Person person) {
        this.number = number;
        this.person = person;
    }
}
