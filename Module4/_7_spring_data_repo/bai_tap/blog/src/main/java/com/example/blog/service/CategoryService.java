package com.example.blog.service;

import com.example.blog.model.Category;

public interface CategoryService {

     Iterable<Category> findAll();

     Category findOne(int id);

     void delete(int id);

     void save(Category category);

}
