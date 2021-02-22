package model.service;

import model.bean.others.ResultValidation;
import model.bean.service.Service;

import java.util.List;
import java.util.Map;

public interface ServiceService {
    boolean insert(Service service);

    boolean delete(String serviceId);

    boolean update(Service service);

    Service getServiceById(String serviceId);

    List<Service> getListService();

    Map<String, ResultValidation> validate(String birthday, String phone, String idCard, String email, String salary);
}
