package spring.furama.service;

import spring.furama.model.employee.AppRole;
import spring.furama.model.employee.AppUser;
import spring.furama.model.employee.UserRole;

public interface AppUserService {
    Iterable<AppRole> findAllRole();

    void save(AppUser appUser);

    void saveUserRole(AppUser appUser, AppRole appRole);

    void save(AppRole appRole);

    AppRole findRoleById(int roleId);
}
