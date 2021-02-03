package org.usefulservice.greeting;

import org.usefullibs.greeter.Greeter;
import org.usefullibs.greeter.impl.HelloWorld;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GreetingServlet",urlPatterns = "/greeting")
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Greeter greeter = new HelloWorld();
        String message = greeter.greet();
        resp.getOutputStream().print(message);
    }
}