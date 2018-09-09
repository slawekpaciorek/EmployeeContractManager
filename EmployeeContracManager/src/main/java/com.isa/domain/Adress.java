package com.isa.domain;

public class Adress {

    private String zipCode;
    private String city;
    private String street;
    private String streetNnumber;
    private String flatNumber;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNnumber() {
        return streetNnumber;
    }

    public void setStreetNnumber(String streetNnumber) {
        this.streetNnumber = streetNnumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return zipCode + " " + city + ", " +
                "\t" + street + " " + streetNnumber + "/" + flatNumber;
    }
}
