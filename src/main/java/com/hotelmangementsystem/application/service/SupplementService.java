package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Supplement;

import java.util.ArrayList;
import java.util.List;

public interface SupplementService {
    public List<Supplement> getAllSupplements();

    public Supplement getSupplement(Long id);

    public Supplement addSupplement(Supplement supplement);

    public Supplement updateSupplement(Long id, Supplement supplement);

    public String deleteSupplement(Long id);
}
