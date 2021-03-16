package spring.furama.repository;

import org.springframework.data.repository.CrudRepository;
import spring.furama.model.contract.ContractDetail;

public interface ContractDetailRepository extends CrudRepository<ContractDetail,Integer> {
}
