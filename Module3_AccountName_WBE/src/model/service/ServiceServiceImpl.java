package model.service;

import model.bean.others.ResultValidation;
import model.bean.service.Service;
import model.repository.ServiceRepository;
import model.repository.ServiceRepositoryImpl;

import java.util.List;
import java.util.Map;

public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository repository = new ServiceRepositoryImpl();
    
    @Override
    public boolean insert(Service service) {
        return repository.insertService(service);
    }

    @Override
    public boolean delete(String serviceId) {
        return repository.deleteService(serviceId);
    }

    @Override
    public boolean update(Service service) {
        return repository.updateService(service);
    }

    @Override
    public Service getServiceById(String serviceId) {
        return repository.getService(serviceId);
    }

    @Override
    public List<Service> getListService() {
        return repository.getListService();
    }

    @Override
    public Map<String, ResultValidation> validate(String birthday, String phone, String idCard, String email, String salary) {
        return null;
    }
}
