package com.example.book_management.service.impl;

import com.example.book_management.model.Book;
import com.example.book_management.model.BookTracking;
import com.example.book_management.model.Customer;
import com.example.book_management.repository.BookRepository;
import com.example.book_management.repository.BookTrackingRepository;
import com.example.book_management.service.BookTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookTrackingServiceImpl implements BookTrackingService {

    private final BookTrackingRepository bookTrackingRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookTrackingServiceImpl(BookTrackingRepository bookTrackingRepository, BookRepository bookRepository) {
        this.bookTrackingRepository = bookTrackingRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void borrowBook(Book book, Customer customer) {
        BookTracking bookTracking = new BookTracking(book, customer, new Date());
        int borrowed = bookTrackingRepository.countAllByBookEqualsAndReturnDateNull(bookTracking.getBook());
        if (borrowed == bookTracking.getBook().getTotal()) {
            return;
        }
        bookTrackingRepository.save(bookTracking);
    }

    @Override
    public void returnBook(BookTracking bookTracking) {
        bookTracking.setReturnDate(new Date());
        bookTrackingRepository.save(bookTracking);
    }

    @Override
    public Map<Integer, Integer> getRemain() {
        Map<Integer, Integer> remains = new HashMap<>();
        Iterable<Book> books = bookRepository.findAll();
        Iterable<BookTracking> trackings = bookTrackingRepository.findAllByReturnDateIsNull();
        for (Book book : books) {
            int count = 0;
            for (BookTracking tracking : trackings) {
                if (tracking.getBook().getId() == book.getId())
                    count++;
            }
            remains.put(book.getId(), book.getTotal() - count);
        }
        return remains;
    }

    @Override
    public Iterable<BookTracking> findByCustomer(Customer customer) {
        return bookTrackingRepository.findAllByCustomerAndReturnDateIsNull(customer);
    }

    @Override
    public BookTracking findById(int id) {
        return bookTrackingRepository.findById(id).orElse(null);
    }
}
