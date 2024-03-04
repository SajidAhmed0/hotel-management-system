package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.repository.ContractRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContract(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract addContract(Contract contract) {
        System.out.println(contract.getHotel());
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract contractDB = contractRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contract with id " + id + " does not exists"));

        if(contract != null){
            contractDB.setStartDate(contract.getStartDate());
            contractDB.setEndDate(contract.getEndDate());
            contractDB.setCancellationPolicy(contract.getCancellationPolicy());
            contractDB.setPaymentPolicy(contract.getPaymentPolicy());
            contractDB.setMarkup(contract.getMarkup());
            return contractRepository.save(contractDB);
        }
        return null;
    }

    @Override
    public String deleteContract(Long id) {
        boolean exists = contractRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Contract with id " + id + " does not exists");
        }
        contractRepository.deleteById(id);
        return "deleted";
    }
}
