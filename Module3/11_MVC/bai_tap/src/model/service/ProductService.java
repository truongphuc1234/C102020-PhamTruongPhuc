package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListProduct();

    void create(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product getProductById(int id);

    Product getProductByName(String name);
}
