package spring.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.furama.model.contract.Contract;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void deleteById(int contractId);

    void update(Contract contract);

    Contract findById(int contractId);

    Iterable<Contract> findAll();
}
