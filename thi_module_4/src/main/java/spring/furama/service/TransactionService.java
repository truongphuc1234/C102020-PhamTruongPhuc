package spring.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.furama.model.Customer;
import spring.furama.model.Transaction;

public interface TransactionService {
    Page<Transaction> findAll(Pageable pageable);

    void save(Transaction transaction);

    Transaction findById(String transactionId);

    void delete(String transactionId);

    Iterable<Transaction> findAll();

    Page<Transaction> findByNameOrService(String customerName, String searchServiceType,Pageable pageable);
}
