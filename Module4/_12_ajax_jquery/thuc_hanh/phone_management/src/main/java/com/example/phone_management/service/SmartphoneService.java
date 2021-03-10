package com.example.phone_management.service;

import com.example.phone_management.model.Smartphone;

public interface SmartphoneService {

    Iterable<Smartphone> findAll();

    Smartphone findById(int id);

    Smartphone save(Smartphone smartphone);

    Smartphone remove(int id);
}
