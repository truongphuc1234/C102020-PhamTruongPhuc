package model.service;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.bean.others.ResultValidation;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    boolean insert(Employee employee);

    boolean delete(int employeeId);

    boolean update(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getListEmployee();

    List<Division> getListDivision();

    List<Position> getListPosition();

    List<EducationDegree> getListEducationDegree();

    List<String> getListUser();

    Map<String, ResultValidation> validate(String id, String birthday, String phone, String idCard, String email);
}
