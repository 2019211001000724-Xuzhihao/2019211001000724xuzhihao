package com.Xuzhihao.week5.derno;

import com.Xuzhihao.dao.UserDao;
import com.Xuzhihao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username=request.getParameter("Username");
        String password=request.getParameter("password");


        UserDao userDao=new UserDao();
        try {
          User user= userDao.findByUsernamePassword(con,Username,password);
          if(user!=null){

              String rememberMe=request.getParameter("rememberMe");
              if(rememberMe!=null&&rememberMe.equals("1")){
                  Cookie usernameCookies=new Cookie("cUsername",user.getUsername());
                  Cookie passwordCookies=new Cookie("cPassword",user.getPassword());
                  Cookie rememberMeCookies=new Cookie("cRememberMe",rememberMe);
                  usernameCookies.setMaxAge(5);
                  passwordCookies.setMaxAge(5);
                  rememberMeCookies.setMaxAge(5);
                  response.addCookie(usernameCookies);
                  response.addCookie(passwordCookies);
                  response.addCookie(rememberMeCookies);
              }

              HttpSession session= request.getSession();
              System.out.println("session id-->"+session.getId());
              session.setMaxInactiveInterval(10);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/view/userInfo.jsp").forward(request,response);
          }else{
              //out.println("Username or password Error!!!");
              request.setAttribute("message","Username or password Error!!!");
              request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request,response);
          }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    /*    String sql="select * from Usertable where username=? and password=?";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,Username);
            pstmt.setString(2,password);
            ResultSet rs= pstmt.executeQuery();
            PrintWriter out=response.getWriter();
            if(rs.next()){

                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getDate("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else {
                //out.println("Username or password Error!!!");
                request.setAttribute("message","Username or password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}