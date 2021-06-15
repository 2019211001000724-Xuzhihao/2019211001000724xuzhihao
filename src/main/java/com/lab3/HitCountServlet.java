package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    @Override
    public void init() throws  ServletException{
        int num=1;
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //PrintWriter out=response.getWriter();
     //   ServletContext sc = request.getServletContext();
       // Object o = sc.getAttribute("access");
      //  if (o != null && o instanceof Integer) {
      //      o = ((Integer) o) + 1;
      ///      out.println("Total Number of Hits");
          //  out.println(o);
        //    sc.setAttribute("access", o);
       // } else {
        //    sc.setAttribute("access", 1);
        //    out.println("Total Number of Hits");
        //    out.println("1");
       // }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
