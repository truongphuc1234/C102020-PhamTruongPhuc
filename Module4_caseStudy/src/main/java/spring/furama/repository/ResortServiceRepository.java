package spring.furama.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.furama.model.service.ResortService;

public interface ResortServiceRepository extends PagingAndSortingRepository<ResortService,String> {
}
