package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.furama.model.employee.Position;
import spring.furama.repository.PositionRepository;
import spring.furama.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }
}
