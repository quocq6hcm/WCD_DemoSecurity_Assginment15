/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.UsersJpaController;

/**
 *
 * @author hoang
 */
public class TestMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WCD_DemoJPAPU");
        UsersJpaController db = new UsersJpaController(emf);
        System.out.println(db.runQuery("SELECT u FROM Users u WHERE u.fullname like '%an%'").size());
//        System.out.println(db.findUsersEntities().size());
//        System.out.println(db.runQuery());
    }
}
