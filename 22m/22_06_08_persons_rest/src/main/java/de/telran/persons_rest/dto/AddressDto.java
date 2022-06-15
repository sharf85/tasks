package de.telran.persons_rest.dto;

public class AddressDto {
    public Integer id;

    public String address;

    public String zip;

    public String city;

    public String country;

    public int personId;

    public AddressDto() {
    }

    public AddressDto(Integer id, String address, String zip, String city, String country, int personId) {
        this.id = id;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
