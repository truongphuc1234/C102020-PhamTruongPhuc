package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.CustomerType;

public interface CustomerTypeRepository extends CrudRepository<CustomerType,Integer> {
}
