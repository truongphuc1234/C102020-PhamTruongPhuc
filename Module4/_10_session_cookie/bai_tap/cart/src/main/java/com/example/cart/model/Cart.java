package com.example.cart.model;

import java.util.Objects;

public class Cart {

    private Product product;
    private int quantity;

    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCurrentPrice() {
        return product.getPrice() * ( 1- product.getDiscountRate()/100);
    }

    public double getTotal() {
        return product.getPrice() * ( 1- product.getDiscountRate()/100)* quantity;
    }

}
