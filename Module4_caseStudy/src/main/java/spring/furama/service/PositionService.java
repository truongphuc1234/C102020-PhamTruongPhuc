package spring.furama.service;

import spring.furama.model.employee.Position;

public interface PositionService {
    Iterable<Position> findAll();

    void save(Position position);
}
