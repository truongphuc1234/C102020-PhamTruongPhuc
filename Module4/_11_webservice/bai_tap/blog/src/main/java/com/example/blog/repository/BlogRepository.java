package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    Page<Blog> findAllByTitleAndCategory(Pageable pageable,String title, Category category);

    Page<Blog> findAllByTitle(Pageable pageable, String title);

    Page<Blog> findAllByCategory(Pageable pageable, Category category);

    Iterable<Blog> findAllByCategory(Category category);
}
