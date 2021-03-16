package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.employee.Division;
import spring.furama.repository.DivisionRepository;
import spring.furama.service.DivisionService;

@Service
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;

    @Autowired
    public DivisionServiceImpl(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }
}
