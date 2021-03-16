package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.service.ServiceType;

public interface ServiceTypeRepository extends CrudRepository<ServiceType,Integer> {
}
