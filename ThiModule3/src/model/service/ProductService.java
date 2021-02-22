package model.service;

import model.bean.Product;
import model.bean.ResultValidation;

import java.util.List;
import java.util.Map;

public interface ProductService {
    boolean insert(Product product);

    List<Product> getTopList(int topRank);

    List<Product> getList();

    List<Product> getTopListByOrderDate(String dateFrom, String dateTo);

    Map<String, ResultValidation> validate(String name, int price, int discount, int stock);

}
