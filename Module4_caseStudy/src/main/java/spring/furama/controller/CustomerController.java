package spring.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.furama.model.Customer;
import spring.furama.model.CustomerType;
import spring.furama.service.CustomerService;
import spring.furama.service.CustomerTypeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerTypeService customerTypeService;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping()
    public String customerIndex(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("customerList", customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/create_type")
    public String createTypeCustomer(Model model) {
        model.addAttribute("customerType", new CustomerType());
        return "customer_type/create";
    }

    @PostMapping("/create_type")
    public String createTypeCustomer(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.save(customerType);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String modifyCustomer(@PathVariable("id") String customerId, Model model){
        model.addAttribute("customer", customerService.findById(customerId));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String modifyCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/";
    }

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> getCustomerType(){
        return customerTypeService.findAll();
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") String customerId){
        customerService.delete(customerId);
        return "redirect:/customer";
    }
}
