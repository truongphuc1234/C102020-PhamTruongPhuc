package spring.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.furama.model.employee.Employee;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void update(Employee employee);

    void save(Employee employee, String username, String password);

    Employee findById(int employeeId);

    void deleteById(int employeeId);

    Iterable<Employee> findAll();
}
