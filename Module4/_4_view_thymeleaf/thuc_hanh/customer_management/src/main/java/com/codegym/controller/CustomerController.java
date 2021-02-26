package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success","Update thành công");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";
    }

    @PostMapping("/customer/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("success","Update thành công");
        return "redirect:/";
    }

    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "delete";
    }

    @PostMapping("customer/delete")
    public String delete(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
