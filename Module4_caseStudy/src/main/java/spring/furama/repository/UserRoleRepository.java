package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.UserRole;
import spring.furama.model.employee.UserRoleKey;

public interface UserRoleRepository extends CrudRepository<UserRole, UserRoleKey> {
}
