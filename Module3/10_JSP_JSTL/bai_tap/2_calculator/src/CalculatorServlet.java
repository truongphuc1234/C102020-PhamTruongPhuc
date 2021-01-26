import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = Float.parseFloat(request.getParameter("first_operand"));
        float second = Float.parseFloat(request.getParameter("second_operand"));
        String operator = request.getParameter("operator");

        float result = Calculator.calculate(first,second,operator);

        request.setAttribute("result",result);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
