package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.employee.EducationDegree;
import spring.furama.repository.EducationDegreeRepository;
import spring.furama.service.EducationDegreeService;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    private final EducationDegreeRepository repository;

    @Autowired
    public EducationDegreeServiceImpl(EducationDegreeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(EducationDegree educationDegree) {
        repository.save(educationDegree);
    }

    @Override
    public Iterable<EducationDegree> findAll() {
        return repository.findAll();
    }
}
