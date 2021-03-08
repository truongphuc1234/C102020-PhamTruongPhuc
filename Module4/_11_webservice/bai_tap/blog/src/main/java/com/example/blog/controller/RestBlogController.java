package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestBlogController {

    private BlogService blogService;

    @Autowired
    public RestBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/api/blog/list")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/api/blog/category/{category_id}")
    public ResponseEntity<List<Blog>> getListBlogByCategory(@PathVariable("category_id") int categoryId){
        List<Blog> blogs = blogService.findByCategory(categoryId);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/api/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
