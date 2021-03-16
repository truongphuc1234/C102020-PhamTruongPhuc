package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.service.RentType;

public interface RentTypeRepository extends CrudRepository<RentType,Integer> {
}
