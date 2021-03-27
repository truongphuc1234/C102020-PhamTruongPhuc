package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.furama.model.Customer;
import spring.furama.model.Transaction;
import spring.furama.repository.TransactionRepository;
import spring.furama.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction findById(String transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    @Override
    public void delete(String transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Page<Transaction> findByNameOrService(String customerName, String searchServiceType,Pageable pageable) {
        return transactionRepository.findAllByCustomerCustomerNameOrServiceType(customerName,searchServiceType,pageable);
    }
}
