package model.repository;

import model.bean.employee.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final String INSERT_EMPLOYEE = "insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_EMPLOYEE = "{CALL delete_employee(?)}";
    private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM employee" +
            " JOIN division ON division.division_id = customer.division_id" +
            " JOIN position ON position.position_id = customer.position_id" +
            " JOIN education_degree ON education_degree.education_degree_id = customer.education_degree_id" +
            " WHERE customer_id = ?";
    private static final String GET_EMPLOYEE_LIST = "SELECT * FROM employee" +
            " JOIN division ON division.division_id = customer.division_id" +
            " JOIN position ON position.position_id = customer.position_id" +
            " JOIN education_degree ON education_degree.education_degree_id = customer.education_degree_id";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET " +
            "employee_name = ?, " +
            "employee_birthday = ?, " +
            "employee_id_card = ?, " +
            "employee_salary = ?, " +
            "employee_phone = ?, " +
            "employee_email = ?, " +
            "employee_address = ?, " +
            "position_id = ?, " +
            "education_degree_id = ?, " +
            "division_id = ?, " +
            "username = ? " +
            "where employee_id = ?";

    private static final String GET_DIVISION_LIST = "SELECT * FROM division";
    private static final String GET_EDUCATION_DEGREE_LIST = "SELECT * FROM education_degree";
    private static final String GET_POSITION_LIST = "SELECT * FROM position";
    private static final String GET_USER_LIST = "SELECT username FROM user";

    @Override
    public boolean insertEmployee(Employee employee) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE)) {
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeBirthday());
            statement.setString(3, employee.getEmployeeIdCard());
            statement.setDouble(4, employee.getEmployeeSalary());
            statement.setString(5, employee.getEmployeePhone());
            statement.setString(6, employee.getEmployeeEmail());
            statement.setString(7, employee.getEmployeeAddress());
            statement.setInt(8, employee.getPositionId());
            statement.setInt(9, employee.getEducationDegreeId());
            statement.setInt(10, employee.getDivisionId());
            statement.setString(11, employee.getUsername());

            if (statement.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             CallableStatement statement = connection.prepareCall(DELETE_EMPLOYEE)) {
            statement.setInt(1, employeeId);
            if (statement.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Employee employee = null;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE_BY_ID)) {
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                employee = new EmployeeView(employeeId,
                        employeeName,
                        employeeBirthday,
                        employeeIdCard,
                        employeeSalary,
                        employeePhone,
                        employeeEmail,
                        employeeAddress,
                        positionId,
                        educationDegreeId,
                        divisionId,
                        username,
                        positionName,
                        educationDegreeName,
                        divisionName);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getListEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                Employee employee = new EmployeeView(employeeId,
                        employeeName,
                        employeeBirthday,
                        employeeIdCard,
                        employeeSalary,
                        employeePhone,
                        employeeEmail,
                        employeeAddress,
                        positionId,
                        educationDegreeId,
                        divisionId,
                        username,
                        positionName,
                        educationDegreeName,
                        divisionName);
                employees.add(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             CallableStatement statement = connection.prepareCall(UPDATE_EMPLOYEE)) {
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeBirthday());
            statement.setString(3, employee.getEmployeeIdCard());
            statement.setDouble(4, employee.getEmployeeSalary());
            statement.setString(5, employee.getEmployeePhone());
            statement.setString(6, employee.getEmployeeEmail());
            statement.setString(7, employee.getEmployeeAddress());
            statement.setInt(8, employee.getPositionId());
            statement.setInt(9, employee.getEducationDegreeId());
            statement.setInt(10, employee.getDivisionId());
            statement.setString(11, employee.getUsername());
            statement.setInt(12, employee.getEmployeeId());
            if (statement.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public List<Division> getListDivision() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_DIVISION_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                Division division = new Division(divisionId, divisionName);
                divisions.add(division);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return divisions;
    }

    @Override
    public List<Position> getListPosition() {
        List<Position> positions = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_POSITION_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                Position position = new Position(positionId, positionName);
                positions.add(position);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public List<EducationDegree> getListEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_EDUCATION_DEGREE_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);
                educationDegrees.add(educationDegree);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return educationDegrees;
    }

    @Override
    public List<String> getListUser() {
        List<String> users = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Role> getListRole() {
        return null;
    }

    @Override
    public List<UserRole> getListUserRole() {
        return null;
    }
}
