package model.service;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.bean.others.ResultValidation;
import model.repository.EmployeeRepository;
import model.repository.EmployeeRepositoryImpl;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl() {
        repository = new EmployeeRepositoryImpl();
    }

    @Override
    public boolean insert(Employee employee) {
        return repository.insertEmployee(employee);
    }

    @Override
    public boolean delete(int employeeId) {
        return repository.deleteEmployee(employeeId);
    }

    @Override
    public boolean update(Employee employee) {
        return repository.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return repository.getEmployee(employeeId);
    }

    @Override
    public List<Employee> getListEmployee() {
        return repository.getListEmployee();
    }

    @Override
    public List<Division> getListDivision() {
        return repository.getListDivision();
    }

    @Override
    public List<Position> getListPosition() {
        return repository.getListPosition();
    }

    @Override
    public List<EducationDegree> getListEducationDegree() {
        return repository.getListEducationDegree();
    }

    @Override
    public List<String> getListUser() {
        return repository.getListUser();
    }

    @Override
    public Map<String, ResultValidation> validate(String id, String birthday, String phone, String idCard, String email) {
        return null;
    }
}
