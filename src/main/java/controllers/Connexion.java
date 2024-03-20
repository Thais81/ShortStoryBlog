/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import forms.ConnexionFormChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Caroline Bergé
 */
@WebServlet("/connexion")
@SuppressWarnings("serial")
public class Connexion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/WEB-INF/connexion.jsp")
                    .forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // récupérer les données du formulaire et les vérifier
        ConnexionFormChecker fc = new ConnexionFormChecker(req);
        Utilisateur u = fc.checkForm();
        // Si erreur => affichage formulaire sinon affichage page OK
        if (fc.getErrors().isEmpty() && u.getEstActif()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            switch (u.getId()) {
                case 1:

                    req.getRequestDispatcher("/WEB-INF/accueilAdmin.jsp")
                            .forward(req, resp);
                    break;
                default:
            resp.sendRedirect(req.getContextPath() + "/");
            //req.getRequestDispatcher("/WEB-INF/connected.jsp")
            // .forward(req, resp);
            }
        } else {

            req.getRequestDispatcher("/WEB-INF/connexion.jsp")
                    .forward(req, resp);
        }
    }

}
