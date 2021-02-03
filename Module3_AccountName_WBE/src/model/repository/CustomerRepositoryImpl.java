package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.bean.customer.CustomerView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String INSERT_CUSTOMER = "INSERT INTO customer (" +
            "customer_id, " +
            "customer_type_id, " +
            "customer_name, " +
            "customer_birthday, " +
            "customer_gender, " +
            "customer_id_card, " +
            "customer_phone, " +
            "customer_email, " +
            "customer_address) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE customer_id = ?";
    private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id WHERE customer_id = ?";
    private static final String GET_CUSTOMER_LIST = "SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id";
    private static final String GET_CUSTOMER_TYPE_LIST = "SELECT * FROM customer_type";
    private static final String UPDATE_CUSTOMER =  "UPDATE customer SET " +
            "customer_type_id = ?,"+
            "customer_name = ?," +
            "customer_birthday = ?," +
            "customer_gender = ?," +
            "customer_id_card = ?," +
            "customer_phone = ?," +
            "customer_email = ?," +
            "customer_address = ? where customer_id = ?";

    @Override
    public boolean insertCustomer(Customer customer) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER)) {
            statement.setString(1, customer.getCustomerId());
            statement.setInt(2, customer.getCustomerTypeId());
            statement.setString(3, customer.getCustomerName());
            statement.setString(4, customer.getCustomerBirthday());
            statement.setInt(5, customer.isCustomerGender() ? 1 : 0);
            statement.setString(6, customer.getCustomerIdCard());
            statement.setString(7, customer.getCustomerPhone());
            statement.setString(8, customer.getCustomerEmail());
            statement.setString(9, customer.getCustomerAddress());

            if (statement.executeUpdate() > 0)
                isSuccess = true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER)) {
            statement.setInt(1, customerId);
            if (statement.executeUpdate() > 0)
                isSuccess = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Customer getCustomer(String customerId) {
        Customer customer = null;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CUSTOMER_BY_ID)) {
            statement.setString(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int customerIdType = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                boolean customerGender = resultSet.getInt("customer_gender") >0;
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                customer = new CustomerView(customerId,customerIdType,customerName,customerBirthday,customerGender,customerIdCard,customerPhone, customerEmail,customerAddress, customerTypeName);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_CUSTOMER_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String customerId = resultSet.getString("customer_id");
                int customerIdType = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                boolean customerGender = resultSet.getInt("customer_gender") >0;
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                Customer customer = new CustomerView(customerId,customerIdType,customerName,customerBirthday,customerGender,customerIdCard,customerPhone, customerEmail,customerAddress, customerTypeName);
                customers.add(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER)) {
            statement.setInt(1, customer.getCustomerTypeId());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerBirthday());
            statement.setInt(4, customer.isCustomerGender() ? 1 : 0);
            statement.setString(5, customer.getCustomerIdCard());
            statement.setString(6, customer.getCustomerPhone());
            statement.setString(7, customer.getCustomerEmail());
            statement.setString(8, customer.getCustomerAddress());
            statement.setString(9,customer.getCustomerId());
            if (statement.executeUpdate() > 0)
                isSuccess = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public List<CustomerType> getCustomerType() {
        List<CustomerType> types = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CUSTOMER_TYPE_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
               int customerTypeId = resultSet.getInt("customer_type_id");
               String customerTypeName = resultSet.getString("customer_type_name");
               CustomerType type = new CustomerType(customerTypeId,customerTypeName);
               types.add(type);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return types;
    }
}
