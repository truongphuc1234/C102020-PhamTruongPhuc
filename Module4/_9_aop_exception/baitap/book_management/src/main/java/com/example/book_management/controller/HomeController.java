package com.example.book_management.controller;

import com.example.book_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private CustomerService customerService;

    @Autowired
    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "/home/home";
    }
}
