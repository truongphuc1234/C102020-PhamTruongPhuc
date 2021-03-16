package spring.furama.service;

import spring.furama.model.service.ServiceType;

public interface ServiceTypeService{
    Iterable<ServiceType> findAll();

    void save(ServiceType serviceType);
}
