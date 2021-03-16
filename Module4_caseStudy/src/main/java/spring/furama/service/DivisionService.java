package spring.furama.service;

import spring.furama.model.employee.Division;

public interface DivisionService {
    Iterable<Division> findAll();

    void save(Division division);
}
