package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(username);

        if(appUser == null){
            System.out.println("User not found! "+ username);
            throw new UsernameNotFoundException("User "+ username+ " was not found in the database");
        }
        System.out.println("Found user: "+ appUser);

        List<UserRole> userRoles = this.userRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> grandLists = new ArrayList<GrantedAuthority>();
        if(userRoles != null){
            for(UserRole userRole: userRoles){
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grandLists.add(authority);
            }
        }

        return new User(appUser.getUserName(), appUser.getEncryptedPassword(),grandLists);
    }
}
