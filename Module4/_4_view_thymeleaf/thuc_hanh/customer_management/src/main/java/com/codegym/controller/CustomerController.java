package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index(Model model, @ModelAttribute("success") String success) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers",customerList);
        return "index";
    }

    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer(1,"abc","bcs","sfd"));
        return "/create";
    }

    @PostMapping("/customer/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        System.out.println(customer);
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success","Update thành công");
        return "redirect:/";
    }
}
