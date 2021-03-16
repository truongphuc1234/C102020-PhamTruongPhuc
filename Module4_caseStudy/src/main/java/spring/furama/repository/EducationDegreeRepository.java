package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.EducationDegree;

public interface EducationDegreeRepository extends CrudRepository<EducationDegree,Integer> {
}
