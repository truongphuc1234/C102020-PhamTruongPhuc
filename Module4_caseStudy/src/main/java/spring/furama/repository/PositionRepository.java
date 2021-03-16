package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.Position;

public interface PositionRepository extends CrudRepository<Position,Integer> {
}
