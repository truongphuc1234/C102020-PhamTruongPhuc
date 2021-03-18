package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.furama.model.employee.AppRole;
import spring.furama.model.employee.AppUser;
import spring.furama.model.employee.UserRole;
import spring.furama.repository.AppRoleRepository;
import spring.furama.repository.AppUserRepository;
import spring.furama.repository.UserRoleRepository;
import spring.furama.service.AppUserService;

@Service
public class AppAppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final AppRoleRepository appRoleRepository;

    @Autowired
    public AppAppUserServiceImpl(AppUserRepository appUserRepository, UserRoleRepository userRoleRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.userRoleRepository = userRoleRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public Iterable<AppRole> findAllRole() {
        return appRoleRepository.findAll();
    }

    @Override
    public void save(AppUser appUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Override
    public void saveUserRole(AppUser appUser, AppRole appRole) {
        UserRole userRole = new UserRole();
        userRole.setAppUser(appUser);
        userRole.setRole(appRole);
        userRoleRepository.save(userRole);
    }

    @Override
    public void save(AppRole appRole) {
        appRoleRepository.save(appRole);
    }

    @Override
    public AppRole findRoleById(int roleId) {
        return appRoleRepository.findById(roleId).orElse(null);
    }
}
