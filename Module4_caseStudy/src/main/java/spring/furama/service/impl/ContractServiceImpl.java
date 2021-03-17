package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.furama.model.contract.Contract;
import spring.furama.repository.ContractRepository;
import spring.furama.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void deleteById(int contractId) {
        contractRepository.deleteById(contractId);
    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(int contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }
}
