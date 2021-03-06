package com.example.book_management.repository;

import com.example.book_management.model.Book;
import com.example.book_management.model.BookTracking;
import com.example.book_management.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookTrackingRepository extends PagingAndSortingRepository<BookTracking,Integer> {

    int countAllByBookEqualsAndReturnDateNull(Book book);

    Iterable<BookTracking> findAllByReturnDateIsNull();

    Iterable<BookTracking> findAllByCustomerAndReturnDateIsNull(Customer customer);
}
