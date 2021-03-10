package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.CategoryRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(Blog blog) {
        blog.setModifiedDate(new Date());
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable,String title, int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(title == null)
            return blogRepository.findAll(pageable);
        if (!"".equals(title)){
            if(category !=null)
                return blogRepository.findAllByTitleAndCategory(pageable, title,category);
            return blogRepository.findAllByTitle(pageable,title);
        }
        if(category != null)
            return blogRepository.findAllByCategory(pageable,category);
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        blog.setModifiedDate(new Date());
        blogRepository.save(blog);
    }
}
