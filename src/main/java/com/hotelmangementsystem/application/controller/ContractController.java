package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public ArrayList<Contract> getAllContract(){
        return contractService.getAllContracts();
    }

    @GetMapping("/{contractId}")
    public Contract getHotel(@PathVariable("contractId") Long contractId) {
        return contractService.getContract(contractId);
    }

    @PostMapping
    public Contract addHotel(@RequestBody Contract contract){
        return contractService.addContract(contract);
    }

    @PutMapping("/{contractId}")
    public Contract updateHotel(@PathVariable("contractId") Long contractId, @RequestBody Contract contract){
        return contractService.updateContract(contractId, contract);
    }

    @DeleteMapping("/{contractId}")
    public String deleteHotel(@PathVariable("contractId") Long contractId){
        return contractService.deleteContract(contractId);
    }

}











