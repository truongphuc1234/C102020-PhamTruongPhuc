package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.AppRole;

public interface AppRoleRepository extends CrudRepository<AppRole,Integer> {
}
