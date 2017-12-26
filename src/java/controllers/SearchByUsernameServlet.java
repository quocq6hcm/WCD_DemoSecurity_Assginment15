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
@WebServlet(name = "SearchByUsernameServlet", urlPatterns = {"/SearchByUsernameServlet"})
public class SearchByUsernameServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WCD_DemoJPAPU");
    UsersJpaController db = new UsersJpaController(emf);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Users> list = new ArrayList();
        String temp = request.getParameter("search");
        if (!temp.isEmpty()) {
            Users u = db.findUsers(temp);
            list.add(u);
        } else {
            list = db.findUsersEntities();
        }
        
        request.setAttribute("users", list);
                request.getRequestDispatcher("ListUser.jsp").forward(request, response);

//        response.sendRedirect("index.jsp");

//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
