package controller;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.bean.others.ResultValidation;
import model.service.CustomerService;
import model.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService service = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                showCustomerMenu(request, response);
                break;
        }
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
            case "search":
                searchByName(request,response);
                break;
            case "view":
                showCustomerById(request, response);
                break;
            default:
                showCustomerMenu(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/customer/list.jsp");
        String name = request.getParameter("name");
        List<Customer> customers = service.getListCustomer();
        List<Customer> customerSearch = new ArrayList<>();
        for(Customer customer: customers){
            if(customer.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                customerSearch.add(customer);
        }
        request.setAttribute("customer_view", customerSearch);
        setCustomerMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("actionUser", "view");
        request.setAttribute("content", "jsp/customer/form.jsp");
        List<CustomerType> customerTypes = service.getListCustomerType();
        request.setAttribute("customer_types", customerTypes);
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            request.setAttribute("msg-fail", "Id customer is not available!");
        } else {
            if (request.getAttribute("validate_false") == null) {
                request.setAttribute("id", customer.getCustomerId());
                request.setAttribute("name", customer.getCustomerName());
                request.setAttribute("birthday", customer.getCustomerBirthday());
                request.setAttribute("id_card", customer.getCustomerIdCard());
                request.setAttribute("phone", customer.getCustomerPhone());
                request.setAttribute("email", customer.getCustomerEmail());
                request.setAttribute("address", customer.getCustomerAddress());
                request.setAttribute("customer_type", customer.getCustomerTypeId());
            }
        }
        setCustomerMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/customer/list.jsp");
        List<Customer> customers = service.getListCustomer();
        request.setAttribute("customer_view", customers);
        setCustomerMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("actionUser", "update");
        request.setAttribute("content", "jsp/customer/form.jsp");
        List<CustomerType> customerTypes = service.getListCustomerType();
        request.setAttribute("customer_types", customerTypes);
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            request.setAttribute("msg-fail", "Id customer is not available!");
        } else {
            if (request.getAttribute("validate_false") == null) {
                request.setAttribute("id", customer.getCustomerId());
                request.setAttribute("name", customer.getCustomerName());
                request.setAttribute("birthday", customer.getCustomerBirthday());
                request.setAttribute("id_card", customer.getCustomerIdCard());
                request.setAttribute("phone", customer.getCustomerPhone());
                request.setAttribute("email", customer.getCustomerEmail());
                request.setAttribute("address", customer.getCustomerAddress());
                request.setAttribute("customer_type", customer.getCustomerTypeId());
            }
        }
        setCustomerMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("actionUser", "create");
        request.setAttribute("content", "jsp/customer/form.jsp");
        List<CustomerType> customerTypes = service.getListCustomerType();
        request.setAttribute("customer_types", customerTypes);
        setCustomerMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAttributes(request);

        String id = request.getParameter("id");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("id_card");
        String email = request.getParameter("email");
        Map<String, ResultValidation> resultValidations = service.validate(id, birthday, phone, idCard, email);
        if (resultValidations.get("birthday").isPass() && resultValidations.get("phone").isPass() && resultValidations.get("id_card").isPass() && resultValidations.get("email").isPass()) {
            int customerType = Integer.parseInt(request.getParameter("customer_type"));
            String name = request.getParameter("name");
            boolean gender = Integer.parseInt(request.getParameter("gender")) > 0;
            String address = request.getParameter("address");
            Customer customer = new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address);
            String msg;
            if (service.update(customer)) {
                msg = "Customer has been updated successful";
            } else {
                msg = "Customer can not be updated";
            }
            request.setAttribute("msg", msg);
        } else {
            request.setAttribute("validate_false", true);
            request.setAttribute("resultValidate", resultValidations);
        }
        showUpdateForm(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAttributes(request);

        String id = request.getParameter("id");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("id_card");
        String email = request.getParameter("email");

        Map<String, ResultValidation> resultValidations = service.validate(id, birthday, phone, idCard, email);
        if (resultValidations.get("total").isPass()) {
            int customerType = Integer.parseInt(request.getParameter("customer_type"));
            String name = request.getParameter("name");
            boolean gender = Integer.parseInt(request.getParameter("gender")) > 0;
            String address = request.getParameter("address");
            Customer customer = new Customer(id, customerType, name, birthday, gender, idCard, phone, email, address);
            String msg;
            if (service.insert(customer)) {
                msg = "Customer has been updated successful";
            } else {
                msg = "Customer can not be created";
            }
            request.setAttribute("msg", msg);
        } else {
            request.setAttribute("resultValidate", resultValidations);
        }
        showCreateForm(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        if(service.delete(id)){
            request.setAttribute("msg","Employee has been deleted successfully");
        } else {
            request.setAttribute("msg-fail","Employee can not be deleted");
        }
        showList(request,response);
    }

    private void setCustomerMenu(HttpServletRequest request) {
        Map<String, String> listMenu = new LinkedHashMap<>();
        listMenu.put("Create Customer", "/customer?actionUser=create");
        listMenu.put("Show All Customer", "/customer?actionUser=list");
        request.setAttribute("list_menu", listMenu);
        request.setAttribute("search","customer");
    }

    private void showCustomerMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCustomerMenu(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void setAttributes(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
    }
}
