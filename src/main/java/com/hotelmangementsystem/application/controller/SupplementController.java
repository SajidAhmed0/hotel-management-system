package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplements")
public class SupplementController {

    @Autowired
    private SupplementService supplementService;

    @GetMapping
    public List<Supplement> getAllSupplements(){
        return supplementService.getAllSupplements();
    }

    @GetMapping("/{id}")
    public Supplement getSupplement(@PathVariable("id") Long id) {
        return supplementService.getSupplement(id);
    }

    @PostMapping
    public Supplement addSupplement(@RequestBody Supplement supplement){
        return supplementService.addSupplement(supplement);
    }

    @PutMapping("/{id}")
    public Supplement updateSupplement(@PathVariable("id") Long id, @RequestBody Supplement supplement){
        return supplementService.updateSupplement(id, supplement);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplement(@PathVariable("id") Long id){
        return supplementService.deleteSupplement(id);
    }
}
