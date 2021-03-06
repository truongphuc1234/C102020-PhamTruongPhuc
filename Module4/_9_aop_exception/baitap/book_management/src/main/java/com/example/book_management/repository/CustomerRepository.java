package com.example.book_management.repository;

import com.example.book_management.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
}
