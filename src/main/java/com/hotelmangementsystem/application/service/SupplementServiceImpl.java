package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.repository.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SupplementServiceImpl implements SupplementService{

    @Autowired
    private SupplementRepository supplementRepository;

    @Override
    public ArrayList<Supplement> getAllSupplements() {
        return (ArrayList<Supplement>) supplementRepository.findAll();
    }

    @Override
    public Supplement getSupplement(Long id) {
        return supplementRepository.findById(id).get();
    }

    @Override
    public Supplement addSupplement(Supplement supplement) {
        return supplementRepository.save(supplement);
    }

    @Override
    public Supplement updateSupplement(Long id, Supplement supplement) {
        Supplement supplementDB = supplementRepository.findById(id).get();
        supplementDB.setName(supplement.getName());
        return supplementRepository.save(supplementDB);
    }

    @Override
    public String deleteSupplement(Long id) {
        supplementRepository.deleteById(id);
        return "delete";
    }
}
