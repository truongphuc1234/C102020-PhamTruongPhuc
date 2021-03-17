package spring.furama.service;

import spring.furama.model.contract.AttachService;

public interface AttachServiceService {
    void save(AttachService attach_service);

    Iterable<AttachService> findAll();
}
