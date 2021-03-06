package com.example.book_management.service;

import com.example.book_management.model.Book;
import com.example.book_management.model.BookTracking;
import com.example.book_management.model.Customer;

import java.util.Map;

public interface BookTrackingService {

    void borrowBook(Book book, Customer customer);

    void returnBook(BookTracking bookTracking);

    Map<Integer,Integer> getRemain();

    Iterable<BookTracking> findByCustomer(Customer customer);

    BookTracking findById(int id);
}
