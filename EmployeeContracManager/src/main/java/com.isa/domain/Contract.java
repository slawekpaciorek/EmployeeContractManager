package com.isa.domain;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Contract {

    private Integer number;
    private Employee employee;
    private LocalDate termOfValidity;
    private double salary;
    private ExpiryTime expiryTime;

    public ExpiryTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(ExpiryTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void salaryUpdate(){
        state.calculateSalary(this);
    }

    public ContractState getState() {
        return state;
    }

    public void setState(ContractState state) {
        this.state = state;
    }

    private ContractState state;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getTermOfValidity() {
        return termOfValidity;
    }

    public void setTermOfValidity(LocalDate termOfValidity) {
        this.termOfValidity = termOfValidity;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number=" + number +
                ", employee=" + employee +
                ", termOfValidity=" + termOfValidity +
                ", salary=" + salary +
                ", expiryTime=" + expiryTime +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return Objects.equals(employee.getEmail(), contract.employee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee.getEmail());
    }
}
