package com.example.blog.repository;

import com.example.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {
}
