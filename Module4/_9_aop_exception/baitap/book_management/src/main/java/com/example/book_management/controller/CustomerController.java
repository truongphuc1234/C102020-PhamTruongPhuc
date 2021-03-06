package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.model.Customer;
import com.example.book_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String list(@RequestParam(defaultValue = "0", required = false, name = "page") int page, Model model) {
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("customers",customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer")Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
}
