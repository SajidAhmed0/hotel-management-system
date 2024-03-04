package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;

import java.util.ArrayList;
import java.util.List;

public interface ContractService {
    public List<Contract> getAllContracts();

    public Contract getContract(Long id);

    public Contract addContract(Contract contract);

    public Contract updateContract(Long id, Contract contract);

    public String deleteContract(Long id);
}
