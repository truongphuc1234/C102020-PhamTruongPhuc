package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.furama.model.service.ResortService;
import spring.furama.repository.ResortServiceRepository;
import spring.furama.service.ResortServiceService;

@Service
public class ResortServiceServiceImpl implements ResortServiceService {

    private final ResortServiceRepository resortServiceRepository;

    @Autowired
    public ResortServiceServiceImpl(ResortServiceRepository resortServiceRepository) {
        this.resortServiceRepository = resortServiceRepository;
    }

    @Override
    public Page<ResortService> findAll(Pageable pageable) {
        return resortServiceRepository.findAll(pageable);
    }

    @Override
    public void save(ResortService resortService) {
        resortServiceRepository.save(resortService);
    }

    @Override
    public ResortService findById(String serviceId) {
        return resortServiceRepository.findById(serviceId).orElse(null);
    }

    @Override
    public void delete(String serviceId) {
        resortServiceRepository.deleteById(serviceId);
    }
}
