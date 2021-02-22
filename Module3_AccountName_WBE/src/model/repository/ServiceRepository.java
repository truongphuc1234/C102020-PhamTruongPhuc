package model.repository;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.util.List;

public interface ServiceRepository extends Repository {
    boolean insertService(Service service);

    boolean deleteService(String serviceId);

    Service getService(String serviceId);

    List<Service> getListService();

    List<ServiceType> getListServiceType();

    List<RentType> getListRentType();

    boolean updateService(Service service);
}
