package com.isa.dao;

import com.isa.domain.Contract;
import com.isa.repository.ContractRepository;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ContractRepoDaoBean implements ContractRepoDao {

    ContractRepository contractRepository = new ContractRepository();

    @Override
    public void addToRepo(Contract contract) {

        contractRepository.addToRepo(contract);
    }

    @Override
    public Contract getFromRepo(String email) {

        return contractRepository.getContractFromRepo(email);
    }

    @Override
    public void update(String email, Contract contract) {

        contractRepository.updateContract(email, contract);    }

    @Override
    public void delete(String email) {
        contractRepository.deleteContracFromRepo(email);
    }

    @Override
    public List<Contract> getAllContracts() {
        return ContractRepository.getRepo();
    }
}
