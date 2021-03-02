package com.example.products.service;

import com.example.products.model.Product;

public interface ProductService {
    Iterable<Product> getListProduct();

    void create(Product product);

    void update(Product product);

    void delete(int id);

    Product getProductById(int id);
}
