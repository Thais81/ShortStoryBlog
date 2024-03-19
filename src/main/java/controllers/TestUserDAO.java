/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.UtilisateurDAO;
import dao.UtilisateurDAO;
import entities.Utilisateur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caroline Bergé
 */
@WebServlet("/test")
public class TestUserDAO extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtilisateurDAO pdao = new UtilisateurDAO();
        Utilisateur p = pdao.read(1);
        System.out.println("p = " + p);
        Utilisateur toadd = new Utilisateur();
        toadd.setPseudo("Sof");
        toadd.setMot_de_passe("Sof");
        System.out.println("toadd =" + toadd);
        pdao.create(toadd);
        System.out.println("add =" + toadd);
        toadd.setMot_de_passe("pogifxd");
        pdao.update(toadd);
        Utilisateur read = pdao.read(toadd.getId());
        System.out.println("read =" + read);
        pdao.delete(toadd.getId());
        System.out.println("deleted");
    }

}
