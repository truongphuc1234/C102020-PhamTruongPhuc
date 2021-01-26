import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Ngân","01-01-2018","Hà Nội","img/1.jpg"));
        customerList.add(new Customer("Thịnh","04-01-2018","Quảng Nam","img/2.jpg"));
        customerList.add(new Customer("Lộc","03-01-2018","Thái Nguyên","img/3.jpg"));
        customerList.add(new Customer("Phước","02-01-2018","Đà Nẵng","img/4.jpg"));

        request.setAttribute("listCustomer",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
