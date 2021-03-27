package spring.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.furama.model.Transaction;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction,String> {
    Page<Transaction> findAllByCustomerCustomerNameOrServiceType(String customerName, String serviceType, Pageable pageable);
}
