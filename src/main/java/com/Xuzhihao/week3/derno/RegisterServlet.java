package com.Xuzhihao.week3.derno;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter( "Username");//name of input type -<input type="text" name="username"/><br/>
        String password =request.getParameter( "password");//<input type="password" name="password"/>
        String email =request.getParameter( "Email");//<input type="text" name="e-mail"/>
        String gender =request.getParameter( "sex");//<input type="radio" name="sex"/>
        String birthDate =request.getParameter( "time");//<input type="text" name="birthDate"/>

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br> username :"+username);
        writer.println("<br> password :"+password);
        writer.println("<br> email :"+email);
        writer.println("<br> gender :"+gender);
        writer.println("<br> birthDate :"+birthDate);
        writer.close();
    }
}
