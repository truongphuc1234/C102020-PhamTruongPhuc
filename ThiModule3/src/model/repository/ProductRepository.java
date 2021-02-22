package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository extends Repository {
    boolean insert(Product product);
    List<Product> getTopList(int topRank);
    List<Product> getList();
    List<Product> getTopListByOrderDate(String dateFrom, String dateTo);
}
