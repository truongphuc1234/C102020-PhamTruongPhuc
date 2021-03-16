package spring.furama.service;

import spring.furama.model.service.RentType;

public interface RentTypeService {
    Iterable<RentType> findAll();

    void save(RentType rentType);
}
