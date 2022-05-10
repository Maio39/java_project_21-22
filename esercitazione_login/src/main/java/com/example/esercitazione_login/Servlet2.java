package com.example.esercitazione_login;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet{
    private String message;

    @Override
    public void init() { message="register"; }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email=req.getParameter("email");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>"+email+"<br>"+password+"<br>"+firstName+"<br>"+lastName+"</body></html>");
    }
}
