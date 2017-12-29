/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.admin;

import entities.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name="UpdateServlet", urlPatterns={"/admin/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
   
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WCD_DemoJPAPU");
    UsersJpaController db = new UsersJpaController(emf);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          Users temp = db.findUsers(request.getParameter("username"));
        request.setAttribute("user" , temp);

        request.getRequestDispatcher("update.jsp").forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            db.edit(new Users(
                    request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("fullname"),
                    request.getParameter("photo"),
                    request.getParameter("email"),
                    Short.parseShort(request.getParameter("level")
                    )));
            response.sendRedirect("ListServlet");
        } catch (Exception ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
