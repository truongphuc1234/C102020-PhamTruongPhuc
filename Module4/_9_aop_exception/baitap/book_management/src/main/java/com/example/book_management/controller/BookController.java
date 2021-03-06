package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String list(@RequestParam(defaultValue = "0", required = false, name = "page") int page, Model model) {
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("books",bookService.findAll(pageable));
        return "book/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("book")Book book){
        bookService.save(book);
        return "redirect:/book";
    }
}
