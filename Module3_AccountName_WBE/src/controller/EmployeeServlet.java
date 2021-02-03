package controller;

import model.service.EmployeeService;
import model.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "EmployeeServlet")
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
                break;
            default:
                showEmployeeMenu(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
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
            case "delete":
                break;
            case "view":
                showEmployeeById(request, response);
                break;
            default:
                showEmployeeMenu(request, response);
                break;
        }
    }

    private void showEmployeeById(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
    }


    private void setEmployeeMenu(HttpServletRequest request) {
        Map<String, String> listMenu = new LinkedHashMap<>();
        listMenu.put("Create Employees", "/employee?actionUser=create");
        listMenu.put("Show All Employees", "/employee?actionUser=list");
        request.setAttribute("list_menu", listMenu);
    }

    private void showEmployeeMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setEmployeeMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
