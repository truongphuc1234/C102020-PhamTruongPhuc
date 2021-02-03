package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.util.List;

public interface CustomerRepository extends Repository {
    boolean insertCustomer(Customer customer);

    boolean deleteCustomer(int customerId);

    Customer getCustomer(String customerId);

    List<Customer> getListCustomer();

    boolean updateCustomer(Customer customer);

    List<CustomerType> getCustomerType();

}
