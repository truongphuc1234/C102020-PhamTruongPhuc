package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
