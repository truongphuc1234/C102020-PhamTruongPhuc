package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.model.Customer;
import com.example.book_management.service.BookService;
import com.example.book_management.service.BookTrackingService;
import com.example.book_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/management")
public class BookManagementController {

    private final CustomerService customerService;
    private final BookService bookService;
    private final BookTrackingService bookTrackingService;

    @Autowired
    public BookManagementController(CustomerService customerService, BookService bookService, BookTrackingService bookTrackingService) {
        this.customerService = customerService;
        this.bookService = bookService;
        this.bookTrackingService = bookTrackingService;
    }

    @GetMapping
    public ModelAndView index(@RequestParam("customer_id") int customerId) {
        ModelAndView modelAndView = new ModelAndView("/management/index");
        modelAndView.addObject("customer_id", customerId);
        return modelAndView;
    }

    @GetMapping("/{id}/borrow")
    public String borrowBook(@PathVariable("id") int customerId, Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("customer", customerService.findById(customerId));
        model.addAttribute("remain", bookTrackingService.getRemain());
        return "/management/borrow";
    }

    @GetMapping("/{id}/return")
    public String returnBook(@PathVariable("id") int customerId, Model model) {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        model.addAttribute("borrows", bookTrackingService.findByCustomer(customer));
        return "/management/return";
    }

    @PostMapping("/borrow")
    public String borrowBookPost(@RequestParam("book_id") int bookId, @RequestParam("customer_id") int customerId, Model model) {
        Book book = bookService.findById(bookId);
        Customer customer = customerService.findById(customerId);
        bookTrackingService.borrowBook(book,customer);
        return "redirect:/management?customer_id="+customerId;
    }

    @PostMapping("/return_book")
    public String returnBookPost(@RequestParam(value = "borrow_id_list",required = false) int[] listReturn, @RequestParam("customer_id") int customerId, Model model){
        for(int id: listReturn){
            bookTrackingService.returnBook(bookTrackingService.findById(id));
        }
        return "redirect:/management?customer_id="+customerId;
    }

    @ExceptionHandler(Exception.class)
    public String showErrorPage(){
        return "/management/error";
    }

}
