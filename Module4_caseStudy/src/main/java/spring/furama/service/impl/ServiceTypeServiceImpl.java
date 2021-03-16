package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.service.ServiceType;
import spring.furama.repository.ServiceTypeRepository;
import spring.furama.service.ServiceTypeService;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private ServiceTypeRepository repository;

    @Autowired
    public ServiceTypeServiceImpl(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<ServiceType> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        repository.save(serviceType);
    }
}
