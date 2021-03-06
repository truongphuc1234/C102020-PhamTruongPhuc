package com.example.book_management.repository;

import com.example.book_management.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,Integer> {
}
