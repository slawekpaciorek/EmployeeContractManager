package com.isa;

import com.isa.domain.Contract;
import com.isa.repository.ContractRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contract> listOfContracts = new ContractRepository().getRepo();

        System.out.println(listOfContracts.toString());
    }
}
