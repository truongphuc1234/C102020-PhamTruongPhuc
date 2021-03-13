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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(Model model,
                       @RequestParam(value = "size",required = false,defaultValue = "5") int size,
                       @RequestParam(value = "page",required = false, defaultValue = "0") int page,
                       @RequestParam("title")Optional<String> title,
                       @RequestParam("category") Optional<Integer> category){
        Pageable pageable = PageRequest.of(page, size,Sort.by("modifiedDate").descending());
        Page<Blog> blogs = blogService.findAll(pageable,title.orElse(null),category.orElse(0));
        model.addAttribute("blogs", blogs);
        return "blog/home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.create(blog);
        return "redirect:/blog/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("edit") Blog blog){
        blogService.update(blog);
        return "redirect:/blog/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        blogService.delete(id);
        return "redirect:/blog/";
    }

    @GetMapping("/view/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
}
