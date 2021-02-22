package model.repository;

import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String GET_LIST_PRODUCT = "select * from product;";
    private static final String INSERT_PRODUCT = "INSERT INTO product (" +
            "product_name, " +
            "product_price, " +
            "discount, " +
            "stock)" +
            " VALUES (?,?,?,?)";

    private static final String GET_LIST_PRODUCT_BY_DATE = "select * from product where product_id in (SELECT product_id from order_product join orders on order_product.order_id = orders.order_id where order_date between ? and ?);";

    private static final String GET_TOP_LIST = "select product.product_id, product.product_name, product.product_price, product.discount, product.stock,SUM(order_product.quantity) as `quantity`\n" +
            "from product left join order_product on product.product_id = order_product.product_id " +
            "group by product.product_id " +
            "order by `quantity` DESC " +
            "limit ?;";

    @Override
    public boolean insert(Product product) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT)) {
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getProductPrice());
            statement.setInt(3, product.getProductDiscount());
            statement.setInt(4, product.getProductStock());
            if (statement.executeUpdate() > 0)
                isSuccess = true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public List<Product> getTopList(int topRank) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_TOP_LIST)) {
            statement.setInt(1, topRank);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productPrice = resultSet.getInt("product_price");
                int productDiscount = resultSet.getInt("discount");
                int productStock = resultSet.getInt("stock");
                Product product = new Product(productId, productName, productPrice, productDiscount, productStock);
                products.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getList() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_LIST_PRODUCT)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productPrice = resultSet.getInt("product_price");
                int productDiscount = resultSet.getInt("discount");
                int productStock = resultSet.getInt("stock");
                Product product = new Product(productId, productName, productPrice, productDiscount, productStock);
                products.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getTopListByOrderDate(String dateFrom, String dateTo) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_LIST_PRODUCT_BY_DATE)) {
            statement.setString(1, dateFrom);
            statement.setString(2, dateTo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productPrice = resultSet.getInt("product_price");
                int productDiscount = resultSet.getInt("discount");
                int productStock = resultSet.getInt("stock");
                Product product = new Product(productId, productName, productPrice, productDiscount, productStock);
                products.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
