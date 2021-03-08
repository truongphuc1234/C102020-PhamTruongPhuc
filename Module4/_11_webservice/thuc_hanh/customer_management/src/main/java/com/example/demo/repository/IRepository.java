package com.example.demo.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();

    T findById(long id);

    void save(T model);

    void remove(long id);
}
