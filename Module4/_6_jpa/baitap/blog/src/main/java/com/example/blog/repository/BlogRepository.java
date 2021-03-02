package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog,Integer> {
}
