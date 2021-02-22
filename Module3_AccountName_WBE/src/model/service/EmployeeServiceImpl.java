package model.service;

import common.Validation;
import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.bean.others.ResultValidation;
import model.repository.EmployeeRepository;
import model.repository.EmployeeRepositoryImpl;

import java.util.HashMap;
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
    public Map<String, ResultValidation> validate(String birthday, String phone, String idCard, String email,String salary) {
        Map<String, ResultValidation> result = new HashMap<>();

        result.put("birthday", Validation.validationDay(birthday));
        result.put("phone", Validation.validationPhone(phone));
        result.put("id_card", Validation.validationIdCard(idCard));
        result.put("email", Validation.validationEmail(email));
        result.put("salary", Validation.validationSalary(salary));

        boolean totalValidation = result.get("salary").isPass() && result.get("birthday").isPass() && result.get("phone").isPass() && result.get("id_card").isPass() && result.get("email").isPass();

        result.put("total", new ResultValidation(totalValidation,null));
        return result;
    }
}
