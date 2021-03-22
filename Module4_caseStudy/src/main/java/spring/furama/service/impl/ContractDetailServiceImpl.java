package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.contract.ContractDetail;
import spring.furama.repository.ContractDetailRepository;
import spring.furama.service.ContractDetailService;
import spring.furama.service.ContractService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    private final ContractDetailRepository contractDetailRepository;

    @Autowired
    public ContractDetailServiceImpl(ContractDetailRepository contractDetailRepository) {
        this.contractDetailRepository = contractDetailRepository;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        ContractDetail contractDetailOrigin = contractDetailRepository.findContractDetailByAttachServiceAndContract(contractDetail.getAttachService(), contractDetail.getContract());
        if (contractDetailOrigin == null) {
            contractDetailRepository.save(contractDetail);
            return;
        }
        int newQuantity = contractDetailOrigin.getQuantity() + contractDetail.getQuantity();
        contractDetailOrigin.setQuantity(newQuantity);
        contractDetailRepository.save(contractDetailOrigin);
    }
}
