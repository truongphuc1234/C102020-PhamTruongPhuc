package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.customer.CustomerType;

public interface CustomerTypeRepository extends CrudRepository<CustomerType,Integer> {
}
