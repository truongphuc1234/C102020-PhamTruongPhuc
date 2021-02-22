package model.repository;

import model.bean.employee.*;

import java.util.List;

public interface EmployeeRepository extends  Repository {
    boolean insertEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);

    Employee getEmployee(int employeeId);

    List<Employee> getListEmployee();

    boolean updateEmployee(Employee employee);

    List<Division> getListDivision();

    List<Position> getListPosition();

    List<EducationDegree> getListEducationDegree();

    List<String> getListUser();

    List<Role> getListRole();

    List<UserRole> getListUserRole();
}
