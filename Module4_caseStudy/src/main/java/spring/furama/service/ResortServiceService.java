package spring.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.furama.model.service.ResortService;

public interface ResortServiceService {
    Page<ResortService> findAll(Pageable pageable);

    void save(ResortService resortService);

    ResortService findById(String serviceId);

    void delete(String serviceId);
}
