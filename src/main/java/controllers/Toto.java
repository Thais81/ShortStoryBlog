/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Helpers.PasswordAuthentication;
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
@WebServlet("/toto")
public class Toto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PasswordAuthentication pa = new PasswordAuthentication();
        for (Utilisateur u : new UtilisateurDAO().list()) {
            System.out.println("utilisateur : " + u.getPseudo() + " // mot de passe : " + pa.hash(u.getMot_de_passe().toCharArray()));
        }
    }

}
