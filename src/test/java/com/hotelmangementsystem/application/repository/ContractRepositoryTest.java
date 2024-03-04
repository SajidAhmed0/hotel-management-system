package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContractRepositoryTest {
    @Autowired
    private ContractRepository contractRepository;

    @Test
    public void addContract(){
        Contract contract = new Contract(new Date(2024, 02, 24), new Date(2024, 03, 24), "cancelation", "payment", 15.0, new Hotel());

        contractRepository.save(contract);
    }
}