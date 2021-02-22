package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductService service = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            case "list":
                showList(request, response);
                break;
            case "get_top":
                showTopList(request,response);
                break;
            case "get_by_date":
                getByDate(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showTopList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/product/list.jsp");
        int rank =Integer.parseInt(request.getParameter("rank"));
        List<Product> products = service.getTopList(rank);
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void getByDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/product/list.jsp");
        String dateFrom = request.getParameter("date_from");
        String dateTo = request.getParameter("date_to");
        List<Product> products = service.getTopListByOrderDate(dateFrom,dateTo);
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("actionUser", "create");
        request.setAttribute("content", "jsp/product/form.jsp");
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "jsp/product/list.jsp");
        List<Product> products = service.getList();
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
