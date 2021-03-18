package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.AppUser;
import spring.furama.model.employee.UserRole;
import spring.furama.model.employee.UserRoleKey;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    List<UserRole> findByAppUser(AppUser appUser);
}
