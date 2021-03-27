package spring.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.furama.model.Customer;
import spring.furama.model.Transaction;
import spring.furama.service.CustomerService;
import spring.furama.service.TransactionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String index(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("transactions", transactionService.findAll(pageable));
        return "transaction/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "transaction/create";
        }
        transactionService.save(transaction);
        return "redirect:/transaction/list";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        model.addAttribute("transaction", transactionService.findById(id));
        return "transaction/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String transactionId) {
        transactionService.delete(transactionId);
        return "redirect:/transaction/list";
    }

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "searchServiceType", defaultValue = "", required = false) String searchServiceType,
                         @RequestParam(value = "searchCustomerName", defaultValue = "", required = false) String searchCustomerName,
                         Model model) {
        Pageable pageable= PageRequest.of(0,5);
        Page<Transaction> transactions = transactionService.findByNameOrService(searchCustomerName,searchServiceType,pageable);
        model.addAttribute("transactions", transactions);
        return "transaction/list";

    }
}
