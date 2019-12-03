package com.telran;

public class CountryCode {
    String countryName;
    int countryCode;

    public CountryCode(String countryName, int countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCountryCode() {
        return countryCode;
    }
}
