package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getListProduct();

    void create(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product getProductById(int id);
}
