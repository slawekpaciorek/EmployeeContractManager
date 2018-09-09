package com.isa.domain;

import org.apache.commons.validator.routines.EmailValidator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Employee {

    private String name;
    private String surname;
    private String email;
    private Adress adress;
    private double salaryBase;

    private boolean emailValidation(String email){
        boolean result = true;
        try{
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        }catch (AddressException ex){
            result = false;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public double getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(double salaryBase) {
        this.salaryBase = salaryBase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(emailValidation(email))
            this.email = email;
        else
            this.email = "Wprowadzono błędny adres email, wprowadź poprawny adres";
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + email;
    }
}
