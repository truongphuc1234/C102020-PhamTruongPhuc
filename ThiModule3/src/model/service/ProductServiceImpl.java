package model.service;

import common.Validation;
import model.bean.Product;
import model.bean.ResultValidation;
import model.repository.ProductRepository;
import model.repository.ProductRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static ProductRepository repository = new ProductRepositoryImpl();

    @Override
    public boolean insert(Product product) {
        return repository.insert(product);
    }

    @Override
    public List<Product> getTopList(int topRank) {
        return repository.getTopList(topRank);
    }

    @Override
    public List<Product> getList() {
        return repository.getList();
    }

    @Override
    public List<Product> getTopListByOrderDate(String dateFrom, String dateTo) {
        return repository.getTopListByOrderDate(dateFrom,dateTo);
    }

    @Override
    public Map<String, ResultValidation> validate(String name, int price,  int discount, int stock){
        Map<String, ResultValidation> result = new HashMap<>();

        result.put("name", Validation.validationName(name));
        result.put("price", Validation.validationPrice(price));
        result.put("discount", Validation.validationDiscount(discount));
        result.put("stock", Validation.validationStock(stock));

        boolean totalValidation = result.get("name").isPass() && result.get("price").isPass() && result.get("discount").isPass() && result.get("stock").isPass();

        result.put("total", new ResultValidation(totalValidation,null));
        return result;
    }
}
