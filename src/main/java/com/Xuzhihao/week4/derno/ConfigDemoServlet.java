package com.Xuzhihao.week4.derno;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(
        urlPatterns ={"/config"},
        initParams = {
                @WebInitParam(name ="name",value ="Xuzhihao"),
                @WebInitParam(name="id",value ="2019211001000724"),
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String id=config.getInitParameter("id");
        PrintWriter writer =response.getWriter();
        writer.println("name  :"+name);
        writer.println("id  :"+id);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
