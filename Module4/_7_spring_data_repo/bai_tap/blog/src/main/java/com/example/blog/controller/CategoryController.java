package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategory(Model model){
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable("id") int id){
        model.addAttribute("category", categoryService.findOne(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        categoryService.delete(id);
        return "redirect:/category/";
    }


}
