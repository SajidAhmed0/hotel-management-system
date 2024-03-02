package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public ArrayList<Contract> getAllContracts() {
        return (ArrayList<Contract>) contractRepository.findAll();
    }

    @Override
    public Contract getContract(Long id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract contractDB = contractRepository.findById(id).get();
        contractDB.setMarkup(contract.getMarkup());
        return contractRepository.save(contractDB);
    }

    @Override
    public String deleteContract(Long id) {
        contractRepository.deleteById(id);
        return "deleted";
    }
}
