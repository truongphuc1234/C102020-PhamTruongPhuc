package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.contract.AttachService;
import spring.furama.repository.AttachServiceRepository;
import spring.furama.service.AttachServiceService;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    private final AttachServiceRepository attachServiceRepository;

    @Autowired
    public AttachServiceServiceImpl(AttachServiceRepository attachServiceRepository) {
        this.attachServiceRepository = attachServiceRepository;
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
