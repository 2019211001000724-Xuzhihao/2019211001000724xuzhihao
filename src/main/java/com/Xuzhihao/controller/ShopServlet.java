package com.Xuzhihao.controller;

import com.Xuzhihao.dao.ProductDao;
import com.Xuzhihao.model.Category;
import com.Xuzhihao.model.Product;
import jdk.internal.dynalink.linker.LinkerServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init()throws  ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category>categoryList= Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProductDao productDao=new ProductDao();
        try {
            if(request.getParameter("categoryId")==null){
                //show all
                List<Product> productList=productDao.findAll(con);
                request.setAttribute("productList",productList);
            }else{
                //show noly one
                int catId=Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList=  productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path="/WEB-INF/view/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
