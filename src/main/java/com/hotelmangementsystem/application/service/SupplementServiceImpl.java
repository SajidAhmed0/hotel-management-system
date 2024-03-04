package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.repository.SupplementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplementServiceImpl implements SupplementService{

    @Autowired
    private SupplementRepository supplementRepository;

    @Override
    public List<Supplement> getAllSupplements() {
        return supplementRepository.findAll();
    }

    @Override
    public Supplement getSupplement(Long id) {
        return supplementRepository.findById(id).orElse(null);
    }

    @Override
    public Supplement addSupplement(Supplement supplement) {
        return supplementRepository.save(supplement);
    }

    @Override
    public Supplement updateSupplement(Long id, Supplement supplement) {
        Supplement supplementDB = supplementRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Supplement with id " + id + " does not exists"));

        if(supplement != null){
            supplementDB.setName(supplement.getName());
            supplementDB.setDescription(supplement.getDescription());
            supplementDB.setPrice(supplement.getPrice());
            return supplementRepository.save(supplementDB);
        }
        return null;
    }

    @Override
    public String deleteSupplement(Long id) {
        boolean exists = supplementRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Supplement with id " + id + " does not exists");
        }
        supplementRepository.deleteById(id);
        return "delete";
    }
}
