package com.isa.dao;

import com.isa.domain.Contract;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContractRepoDao {

    public void addToRepo(Contract contract);

    public Contract getFromRepo(String email);

    public void update(String email, Contract contract);

    public void delete(String email);

    public List<Contract> getAllContracts();

}
