package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;

import java.util.ArrayList;

public interface ContractService {
    public ArrayList<Contract> getAllContracts();

    public Contract getContract(Long id);

    public Contract addContract(Contract contract);

    public Contract updateContract(Long id, Contract contract);

    public String deleteContract(Long id);
}
