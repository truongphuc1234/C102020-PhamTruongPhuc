package spring.furama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.furama.model.employee.Employee;
import spring.furama.repository.AppUserRepository;
import spring.furama.repository.EmployeeRepository;
import spring.furama.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AppUserRepository appUserRepository) {
        this.employeeRepository = employeeRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void update(Employee employee) {
        Employee originEmployee = findById(employee.getEmployeeId());
        employee.setAppUser(originEmployee.getAppUser());
        employeeRepository.save(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
