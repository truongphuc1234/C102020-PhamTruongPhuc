package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListProduct();

    void create(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product getProductById(int id);
}
