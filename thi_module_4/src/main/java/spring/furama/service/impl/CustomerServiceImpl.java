package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.furama.model.Customer;
import spring.furama.repository.CustomerRepository;
import spring.furama.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void delete(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByName(String searchCustomerName) {
        return customerRepository.findCustomerByCustomerNameContains(searchCustomerName);
    }
}
