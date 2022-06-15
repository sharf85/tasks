package de.telran.persons_rest.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String address;

    private String zip;

    private String city;

    private String country;

    @ManyToOne
    private Person person;

    public Address() {
    }

    public Address(String address, String zip, String city, String country, Person person) {
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Person getPerson() {
        return person;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
