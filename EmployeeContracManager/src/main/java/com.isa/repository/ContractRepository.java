package com.isa.repository;

import com.isa.domain.Adress;
import com.isa.domain.Contract;
import com.isa.domain.ContractState;
import com.isa.domain.Employee;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ContractRepository {

    private static List<Contract> contractsRepository = new ArrayList<>();


    public static void addToRepo(Contract contract) {
        contractsRepository.add(contract);
    }

    public static List<Contract> getRepo() {
//        if(contractsRepository.size() == 0){
//            fillWithDefaults();
//        }
        return contractsRepository;
    }

    public static Contract getContractFromRepo(String email) {
        return contractsRepository.stream().filter(contract -> contract.getEmployee().getEmail().equals(email)).findAny().get();
    }

    public static void fillWithDefaults() {
        Adress adress = new Adress();
        Employee employee = new Employee();
        Contract contract = new Contract();

        adress.setZipCode("00-496");
        adress.setCity("Warszawa");
        adress.setStreet("Marszałkowska");
        adress.setStreetNnumber("32");
        adress.setFlatNumber("30");

        employee.setName("Łukasz");
        employee.setSurname("Wielk");
        employee.setEmail("lw@hotmail.com");
        employee.setAdress(adress);
        employee.setSalaryBase(90.5);

        contract.setEmployee(employee);
        contract.setNumber(1);
        contract.setState(ContractState.B2B);
        contract.salaryUpdate();
        contract.setTermOfValidity(LocalDate.now());

        contractsRepository.add(contract);
    }

    public static void updateContract(String email, Contract contract) {

        deleteContracFromRepo(email);
        addToRepo(contract);

    }

    public static void deleteContracFromRepo(String email) {
        contractsRepository.remove(getContractFromRepo(email));
    }
}
