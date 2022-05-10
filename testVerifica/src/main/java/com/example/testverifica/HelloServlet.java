package com.example.testverifica;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    String firstName;
    String lastName;
    String email;
    String password;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        firstName = req.getParameter("first-name");
        lastName = req.getParameter("last-name");
        email = req.getParameter("email");
        password = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>"+"ciao "+email+"<br>"+firstName+"<br>"+lastName+"<br>"+"</body></html>");
    }


    public void destroy() {
    }
}
