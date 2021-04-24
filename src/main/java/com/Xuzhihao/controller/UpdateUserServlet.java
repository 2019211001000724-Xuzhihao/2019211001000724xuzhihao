package com.Xuzhihao.controller;

import com.Xuzhihao.dao.UserDao;
import com.Xuzhihao.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id= Integer.parseInt(request.getParameter("id"));
        String Username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date Date= null;
            Date = sdf.parse(request.getParameter("birthdate"));
            User user=new User();
            user.setId(Id);
            user.setUsername(Username);
            user.setPassword(password);
            user.setEmail(Email);
            user.setGender(Gender);
            user.setBirthDate(Date);
            UserDao userDao=new UserDao();
            Connection con = (Connection) getServletContext().getAttribute("con");
            try {
                if(userDao.updateUser(con,user)!=0) {
                    User user1=userDao.findByUsernamePassword(con,Username,password);
                    HttpSession session=request.getSession();
                    session.setMaxInactiveInterval(10);
                    session.setAttribute("user",user1);
                    request.getRequestDispatcher("WEB-INF/view/userInfo.jsp").forward(request, response);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
