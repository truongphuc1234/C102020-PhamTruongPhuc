package model.service;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.bean.others.ResultValidation;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    boolean insert(Customer customer);

    boolean delete(int customerId);

    boolean update(Customer customer);

    Customer getCustomerById(String customerId);

    List<Customer> getListCustomer();

    List<CustomerType> getListCustomerType();

    Map<String, ResultValidation> validate(String id, String birthday, String phone, String idCard, String email);
}
