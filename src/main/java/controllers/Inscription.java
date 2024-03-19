/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forms.InscriptionFormChecker;
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
@WebServlet("/inscription")
@SuppressWarnings("serial")
public class Inscription extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/accueil/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les données du formulaire et les vérifier
        InscriptionFormChecker ifc = new InscriptionFormChecker(req);
        Utilisateur u = ifc.checkForm();
        // Si erreur => affichage formulaire sinon affichage page OK
        if (!ifc.getErrors().isEmpty()) {
            // Si le formulaire est valide, vous pouvez rediriger vers une autre page
            //resp.sendRedirect("/blog/inscrip"); si utilisation de sendRedirect creer un controller 
            req.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);

        } else {
            // Si des erreurs sont présentes, afficher à nouveau le formulaire avec les erreurs
            //req.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            resp.sendRedirect("/accueil/");

        }
    }

}
