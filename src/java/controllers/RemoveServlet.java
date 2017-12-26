/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

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
import models.exceptions.NonexistentEntityException;

/**
 *
 * @author hoang
 */
@WebServlet(name="RemoveServlet", urlPatterns={"/RemoveServlet"})
public class RemoveServlet extends HttpServlet {
   
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WCD_DemoJPAPU");
    UsersJpaController db = new UsersJpaController(emf);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            db.destroy(request.getParameter("username"));
            response.sendRedirect("ListServlet");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(RemoveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

   
}
