package spring.furama.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.furama.model.contract.Contract;

public interface ContractRepository extends PagingAndSortingRepository<Contract,Integer> {
}
