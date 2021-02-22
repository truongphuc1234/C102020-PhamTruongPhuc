package controller;

import model.bean.employee.*;
import model.bean.others.ResultValidation;
import model.service.EmployeeService;
import model.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService service = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                showEmployeeMenu(request, response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        if(service.delete(id)){
            request.setAttribute("msg","Employee has been deleted successfully");
        } else {
            request.setAttribute("msg-fail","Employee can not be deleted");
        }
        showList(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "list":
                showList(request, response);
                break;
            case "view":
                showEmployeeById(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                showEmployeeMenu(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/employee/list.jsp");
        String name = request.getParameter("name");
        List<Employee> employees = service.getListEmployee();
        List<Employee> employeesSearch = new ArrayList<>();
        for(Employee employee: employees){
            if(employee.getEmployeeName().toLowerCase().contains(name.toLowerCase()))
                employeesSearch.add(employee);
        }
        request.setAttribute("employee_view", employeesSearch);
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showEmployeeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("actionUser", "view");
        request.setAttribute("content", "jsp/employee/form.jsp");
        List<Position> positions = service.getListPosition();
        request.setAttribute("positions", positions);
        List<Division> divisions = service.getListDivision();
        request.setAttribute("divisions", divisions);
        List<EducationDegree> educationDegrees = service.getListEducationDegree();
        request.setAttribute("education_degrees", educationDegrees);
        List<String> users = service.getListUser();
        request.setAttribute("users", users);
        Employee employee = service.getEmployeeById(id);
        if (employee == null) {
            request.setAttribute("msg-fail", "Id employee is not available!");
        } else {
            request.setAttribute("id", employee.getEmployeeId());
            request.setAttribute("name", employee.getEmployeeName());
            request.setAttribute("birthday", employee.getEmployeeBirthday());
            request.setAttribute("id_card", employee.getEmployeeIdCard());
            request.setAttribute("salary", employee.getEmployeeSalary());
            request.setAttribute("phone", employee.getEmployeePhone());
            request.setAttribute("email", employee.getEmployeeEmail());
            request.setAttribute("address", employee.getEmployeeAddress());
            request.setAttribute("position", employee.getPositionId());
            request.setAttribute("education_degree", employee.getEducationDegreeId());
            request.setAttribute("division", employee.getDivisionId());
            request.setAttribute("username", employee.getUsername());
        }
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/employee/list.jsp");
        List<Employee> employees = service.getListEmployee();
        request.setAttribute("employee_view", employees);
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("actionUser", "update");
        request.setAttribute("content", "jsp/employee/form.jsp");
        List<Position> positions = service.getListPosition();
        request.setAttribute("positions", positions);
        List<Division> divisions = service.getListDivision();
        request.setAttribute("divisions", divisions);
        List<EducationDegree> educationDegrees = service.getListEducationDegree();
        request.setAttribute("education_degrees", educationDegrees);
        List<String> users = service.getListUser();
        request.setAttribute("users", users);
        Employee employee = service.getEmployeeById(id);
        if (employee == null) {
            request.setAttribute("msg-fail", "Id employee is not available!");
        } else {
            if (request.getAttribute("validate_false") == null) {
                request.setAttribute("id", employee.getEmployeeId());
                request.setAttribute("name", employee.getEmployeeName());
                request.setAttribute("birthday", employee.getEmployeeBirthday());
                request.setAttribute("id_card", employee.getEmployeeIdCard());
                request.setAttribute("salary", employee.getEmployeeSalary());
                request.setAttribute("phone", employee.getEmployeePhone());
                request.setAttribute("email", employee.getEmployeeEmail());
                request.setAttribute("address", employee.getEmployeeAddress());
                request.setAttribute("position", employee.getPositionId());
                request.setAttribute("education_degree", employee.getEducationDegreeId());
                request.setAttribute("division", employee.getDivisionId());
                request.setAttribute("username", employee.getUsername());
            }
        }
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("actionUser", "create");
        request.setAttribute("content", "jsp/employee/form.jsp");
        List<Position> positions = service.getListPosition();
        request.setAttribute("positions", positions);
        List<Division> divisions = service.getListDivision();
        request.setAttribute("divisions", divisions);
        List<EducationDegree> educationDegrees = service.getListEducationDegree();
        request.setAttribute("education_degrees", educationDegrees);
        List<String> users = service.getListUser();
        request.setAttribute("users", users);
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAttributes(request);

        String birthday = (String) request.getAttribute("birthday");
        String phone = (String) request.getAttribute("phone");
        String idCard = (String) request.getAttribute("id_card");
        String email = (String) request.getAttribute("email");
        String salary = (String) request.getAttribute("salary");

        Map<String, ResultValidation> resultValidations = service.validate(birthday, phone, idCard, email, salary);

        if (resultValidations.get("total").isPass()) {
            Double salaryNumber = Double.parseDouble(salary);
            String name = (String) request.getAttribute("name");
            String address = (String) request.getAttribute("address");
            int positionId = Integer.parseInt((String) request.getAttribute("position"));
            int educationDegreeId = Integer.parseInt((String) request.getAttribute("education_degree"));
            int divisionId = Integer.parseInt((String) request.getAttribute("division"));
            String username = (String) request.getAttribute("username");
            Employee employee = new Employee(0, name, birthday, idCard, salaryNumber, phone, email, address, positionId, educationDegreeId, divisionId, username);
            String msg;
            if (service.insert(employee)) {
                msg = "Employee has been updated successful";
            } else {
                msg = "Employee can not be created";
            }
            request.setAttribute("msg", msg);
        } else {
            request.setAttribute("resultValidate", resultValidations);
        }
        showCreateForm(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAttributes(request);

        String birthday = (String) request.getAttribute("birthday");
        String phone = (String) request.getAttribute("phone");
        String idCard = (String) request.getAttribute("id_card");
        String email = (String) request.getAttribute("email");
        String salary = (String) request.getAttribute("salary");

        Map<String, ResultValidation> resultValidations = service.validate(birthday, phone, idCard, email, salary);

        if (resultValidations.get("total").isPass()) {
            Double salaryNumber = Double.parseDouble(salary);
            int id = Integer.parseInt((String) request.getAttribute("id"));
            String name = (String) request.getAttribute("name");
            String address = (String) request.getAttribute("address");
            int positionId = Integer.parseInt((String) request.getAttribute("position"));
            int educationDegreeId = Integer.parseInt((String) request.getAttribute("education_degree"));
            int divisionId = Integer.parseInt((String) request.getAttribute("division"));
            String username = (String) request.getAttribute("username");
            Employee employee = new Employee(id, name, birthday, idCard, salaryNumber, phone, email, address, positionId, educationDegreeId, divisionId, username);
            String msg;
            if (service.update(employee)) {
                msg = "Employee has been updated successful";
            } else {
                msg = "Employee can not be update";
            }
            request.setAttribute("msg", msg);
        } else {
            request.setAttribute("validate_false", true);
            request.setAttribute("resultValidate", resultValidations);
        }
        showUpdateForm(request, response);
    }

    private void showEmployeeMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void setEmployeeMenu(HttpServletRequest request) {
        Map<String, String> listMenu = new LinkedHashMap<>();
        listMenu.put("Create Employees", "/employee?actionUser=create");
        listMenu.put("Show All Employees", "/employee?actionUser=list");
        request.setAttribute("list_menu", listMenu);
        request.setAttribute("search","employee");
    }

    private void setAttributes(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
    }
}
