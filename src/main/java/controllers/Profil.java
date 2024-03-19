/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Caroline Bergé
 */
@WebServlet("/profil")
public class Profil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Afficher la page de profil avec le formulaire de changement de mot de passe
        Utilisateur user = (Utilisateur) req.getSession().getAttribute("user");
        int idUtilisateur = 0;
        if (user != null) {
            idUtilisateur = user.getId();
        }

        // req.setAttribute("nouvelles", new NouvelleDAO().list(idUtilisateur));
        req.getRequestDispatcher("/WEB-INF/profil.jsp").forward(req, resp);
    }

    /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les données du formulaire de changement de mot de passe
        String Mot_de_passe = req.getParameter("mot_de_passe");
        String newMot_de_passe = req.getParameter("newMdp");
        String verif = req.getParameter("verif");

        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        ProfilFormChecker fc = new ProfilFormChecker(req);
        Utilisateur user = fc.checkForm();
        if (fc.getErrors().isEmpty()) {
            req.setAttribute("changed", "Votre mot de passe a été changé");
        }
        req.getRequestDispatcher("/WEB-INF/profil.jsp").forward(req, resp);

}*/
}
