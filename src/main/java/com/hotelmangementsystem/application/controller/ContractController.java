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
    public ArrayList<Contract> getAllContracts(){
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContract(@PathVariable("id") Long id) {
        return contractService.getContract(id);
    }

    @PostMapping
    public Contract addContract(@RequestBody Contract contract){
        return contractService.addContract(contract);
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable("id") Long id, @RequestBody Contract contract){
        return contractService.updateContract(id, contract);
    }

    @DeleteMapping("/{id}")
    public String deleteContract(@PathVariable("id") Long id){
        return contractService.deleteContract(id);
    }

}











