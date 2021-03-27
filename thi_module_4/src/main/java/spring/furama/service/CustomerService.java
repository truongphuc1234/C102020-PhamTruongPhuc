package spring.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.furama.model.Customer;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(int customerId);

    void delete(int customerId);

    Iterable<Customer> findAll();

    Customer findByName(String searchCustomerName);
}
