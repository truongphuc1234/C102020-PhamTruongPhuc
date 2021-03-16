package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.service.RentType;
import spring.furama.repository.RentTypeRepository;
import spring.furama.service.RentTypeService;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    private final RentTypeRepository rentTypeRepository;

    @Autowired
    public RentTypeServiceImpl(RentTypeRepository rentTypeRepository) {
        this.rentTypeRepository = rentTypeRepository;
    }

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }
}
