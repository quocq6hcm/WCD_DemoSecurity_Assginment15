/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UsersJpaController;

/**
 *
 * @author hoang
 */
@WebServlet(name = "SearchByFullnameServlet", urlPatterns = {"/SearchByFullnameServlet"})
public class SearchByFullnameServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WCD_DemoJPAPU");
    UsersJpaController db = new UsersJpaController(emf);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Users> list = new ArrayList();
        String temp = request.getParameter("searchF");
        if (!temp.isEmpty()) {
                    list = db.runQuery("SELECT u FROM Users u WHERE u.fullname like '%"+temp+"%'");

        }
        else
        {
              list = db.findUsersEntities();
        }
        
        request.setAttribute("users", list);
          request.getRequestDispatcher("ListUser.jsp").forward(request, response);

//        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
