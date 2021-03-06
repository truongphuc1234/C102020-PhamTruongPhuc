package com.example.book_management.service;

import com.example.book_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);
}
