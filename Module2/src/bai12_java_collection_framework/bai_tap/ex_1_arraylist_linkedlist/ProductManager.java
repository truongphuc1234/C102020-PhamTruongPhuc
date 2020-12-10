package bai12_java_collection_framework.bai_tap.ex_1_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    ProductManager() {
        products = new ArrayList<>();
    }

    public boolean add(Product product) {
        if (contain(product.getId())) {
            return false;
        } else {
            products.add(product);
            return true;
        }
    }

    public boolean contain(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void edit(int id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, newProduct);
            }
        }
    }

    public boolean delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product search(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void sortByPrice(boolean ascending) {
        if (ascending) {
            Collections.sort(products, Comparator.<Product>
                    comparingDouble(product1 -> product1.getPrice()).
                    thenComparingDouble(product2 -> product2.getPrice()));
        } else {
            Collections.sort(products, Comparator.<Product>
                    comparingDouble(product1 -> -product1.getPrice()).
                    thenComparingDouble(product2 -> -product2.getPrice()));
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Product product : products) {
            result += product.toString() + "\n";
        }
        return result;
    }
}