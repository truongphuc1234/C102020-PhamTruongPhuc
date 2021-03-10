package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(Model model) {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("modifiedDate").descending());
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "blog/home";
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> searchBlog(@RequestParam(value = "title", defaultValue = "") String title, @RequestParam(value = "category", defaultValue = "0") int category, @RequestParam(value = "page",required = false,defaultValue = "0")int page) {
        System.out.println(title);
        System.out.println(category);
        Pageable pageable = PageRequest.of(page, 5);
        Page<Blog> blogs = blogService.findAll(pageable, title, category);
        return blogs;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("edit") Blog blog) {
        blogService.update(blog);
        return "redirect:/blog/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        blogService.delete(id);
        return "redirect:/blog/";
    }

    @GetMapping("/view/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

}
