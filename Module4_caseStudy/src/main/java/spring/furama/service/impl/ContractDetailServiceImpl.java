package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.contract.ContractDetail;
import spring.furama.repository.ContractDetailRepository;
import spring.furama.service.ContractDetailService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    private final ContractDetailRepository contractDetailRepository;

    @Autowired
    public ContractDetailServiceImpl(ContractDetailRepository contractDetailRepository) {
        this.contractDetailRepository = contractDetailRepository;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
