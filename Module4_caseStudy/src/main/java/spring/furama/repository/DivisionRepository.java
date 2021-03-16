package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.Division;

public interface DivisionRepository extends CrudRepository<Division,Integer> {
}
