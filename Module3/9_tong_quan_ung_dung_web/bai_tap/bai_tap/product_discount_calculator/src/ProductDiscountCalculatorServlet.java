import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = "/display-discount")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("percent"));

        double amount = price*percent*0.01;
        double newPrice = price - amount;


        request.setAttribute("description",description);
        request.setAttribute("price",price);
        request.setAttribute("percent",percent);
        request.setAttribute("amount",amount);
        request.setAttribute("newPrice",newPrice);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
