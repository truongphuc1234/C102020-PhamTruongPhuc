package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.contract.AttachService;
import spring.furama.model.contract.Contract;
import spring.furama.model.contract.ContractDetail;

public interface ContractDetailRepository extends CrudRepository<ContractDetail,Integer> {
    ContractDetail findContractDetailByAttachServiceAndContract(AttachService attachService, Contract contract);
}
