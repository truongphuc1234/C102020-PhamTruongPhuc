package com.example.phone_management.service.impl;

import com.example.phone_management.model.Smartphone;
import com.example.phone_management.repository.SmartphoneRepository;
import com.example.phone_management.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    private SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneServiceImpl(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(int id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone remove(int id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}
