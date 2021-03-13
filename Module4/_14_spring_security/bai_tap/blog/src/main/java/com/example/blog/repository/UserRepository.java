package com.example.blog.repository;

import com.example.blog.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<AppUser,Long> {
    AppUser findByUserName(String username);

    List<String> findUserName();
}
