package com.example.maierverifica;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String s;
        String nome;
        String cognome;

        PrintWriter out = response.getWriter();

        try{
            FileReader fr = new FileReader("/Users/marcomaier/documenti/Java_project/MaierVerifica/login.txt");
            BufferedReader fIn = new BufferedReader(fr);
            boolean trovato=false;
            nome=fIn.readLine();
            cognome=fIn.readLine();
            s=fIn.readLine();

            while(s!=null){
                s=s.toLowerCase();
                email=email.toLowerCase();
                password=password.toLowerCase();
                if(s.equals(email)){
                    s=fIn.readLine();
                    s=s.toLowerCase();
                    if(s.equals(password)){
                        out.println("<html><body>"+"Ciao "+nome+" "+cognome+"<br>"+"questo è il tuo account"+"</body></html>");
                        trovato = true;
                    }else{
                       trovato=false;
                    }
                }else{
                    trovato=false;
                }
                nome=fIn.readLine();
                cognome=fIn.readLine();
                s=fIn.readLine();
            }
            if(!trovato){
                out.println("<html><body>"+"<h2>Questo Account o non esiste o e errato</h2>"+"<br>"+"</body></html>");
                out.println("<html><body>"+"<h3>Clicca qui per registrarti</h3>"+"<a href=\"index.jsp\">Regitrazione</a>"+"<br>"+"</body></html>");
                out.println("<html><body>"+"<h3>Se ti sei gia registrato riprova</h3>"+"<br>"+"</body></html>");

            }
        }catch (IOException e){

        }
    }
}
