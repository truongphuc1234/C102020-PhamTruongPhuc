package spring.furama.service;

import spring.furama.model.employee.EducationDegree;

public interface EducationDegreeService {
    void save(EducationDegree educationDegree);
    Iterable<EducationDegree> findAll();
}
