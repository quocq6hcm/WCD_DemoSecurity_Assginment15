/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;

import java.io.IOException;
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
@WebServlet("/admin/ListServlet")
public class ListServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WCD_DemoJPAPU");
    UsersJpaController db = new UsersJpaController(emf);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("users", db.findUsersEntities());
        
       
               request.getRequestDispatcher("/views/admin/index.jsp").forward(request, response);
 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
