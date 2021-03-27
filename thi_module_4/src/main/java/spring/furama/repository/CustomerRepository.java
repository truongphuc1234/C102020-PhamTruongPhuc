package spring.furama.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.furama.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    Customer findCustomerByCustomerNameContains(String name);
}
