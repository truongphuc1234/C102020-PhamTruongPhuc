package spring.furama.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.furama.model.customer.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,String> {
    boolean existsByCustomerEmail(String email);
}
