package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.employee.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser,String> {
}
