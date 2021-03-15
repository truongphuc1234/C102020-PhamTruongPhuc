package spring.furama.service;

import spring.furama.model.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();

    void save(CustomerType customerType);
}
