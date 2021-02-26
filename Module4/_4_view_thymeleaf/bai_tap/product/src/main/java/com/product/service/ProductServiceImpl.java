package com.product.service;

import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new TreeMap<>();

    static {
        products.put(1,new Product(1,"Milk",1000.5,"sữa tươi","Vinamilk"));
        products.put(2,new Product(2,"Tea",2000.5,"nước mắm","Pikachu"));
        products.put(3,new Product(3,"Water",3000.5f,"đường","Doremon"));
        products.put(4,new Product(4,"Beer",4000.5f,"hạt nêm","Nobita"));
        products.put(5,new Product(5,"Oil",5000.5f,"hat tiêu","Xuka"));
        products.put(6,new Product(6,"Ice cream",6000.5f,"bia","Chaien"));
        products.put(7,new Product(7,"Coca cola",8000.5f,"mắm tôm","Xeko"));
    }
    @Override
    public List<Product> getListProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }

}
