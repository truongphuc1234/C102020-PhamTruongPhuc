package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"", "/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "employee":
                showEmployee(request, response);
                break;
            case "customer":
                showCustomer(request, response);
                break;
            case "service":
                showService(request, response);
                break;
            case "contract":
                showContract(request, response);
                break;
            default:
                response.sendRedirect("home.jsp");
        }
    }

    private void showContract(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("a");
    }

    private void showService(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("a");
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/customer").forward(request,response);
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/employee").forward(request,response);
    }
}
