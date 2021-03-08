package com.example.cart.service.impl;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.repository.ProductRepository;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addToCart(Map<Product, Cart> carts, int id) {
        Product product = findById(id);
        if (carts.containsKey(product)) {
            int newQuantity = carts.get(product).getQuantity() + 1;
            carts.get(product).setQuantity(newQuantity);
        } else {
            carts.put(product, new Cart(product, 1));
        }
    }

    @Override
    public double getTotal(Map<Product, Cart> carts) {
        double total = 0;
        for (Cart cart : carts.values()) {
            total += cart.getTotal();
        }
        return total;
    }

    @Override
    public void delete(Map<Product, Cart> carts, int id) {
        Product product = findById(id);
        carts.remove(product);
    }

    @Override
    public void update(Map<Product, Cart> carts, int id, int quantity) {
        Product product = findById(id);
        carts.put(product, new Cart(product, quantity));
    }
}
