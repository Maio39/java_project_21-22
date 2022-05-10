package com.example.maierverifica;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>"+"ciao "+firstName+" "+lastName+"<br>"+"La tua registrazione è stata completata con successo!!"+"</body></html>");
        out.println("<html><body>"+"<br>"+"Ora Accedi al tuo account"+"<br>"+"<a href=\"login.jsp\">Login</a>"+"</body></html>");

        GestioneFile gs = new GestioneFile();
        gs.inputFile(firstName,lastName,email,password);

    }

    public void destroy() {
    }
}