package com.example.cart.service;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Product findById(int id);

    void addToCart(Map<Product, Cart> carts, int id);

    double getTotal(Map<Product, Cart> carts);

    void delete(Map<Product, Cart> carts, int id);

    void update(Map<Product, Cart> carts, int id, int quantity);

}
