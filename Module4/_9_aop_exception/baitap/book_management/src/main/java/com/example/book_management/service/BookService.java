package com.example.book_management.service;

import com.example.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<Book> findAll(Pageable pageable);

    Iterable<Book> findAll();

    Book findById(int id);

    void save(Book book);
}
