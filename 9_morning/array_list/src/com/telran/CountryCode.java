package com.telran;

public class CountryCode {

    public CountryCode(String countryName, int code) {
        this.countryName = countryName;
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCode() {
        return code;
    }

    private String countryName;
    private int code;

    @Override
    public String toString() {
        return "CountryCode{" +
                "countryName='" + countryName + '\'' +
                ", code=" + code +
                '}';
    }
}
