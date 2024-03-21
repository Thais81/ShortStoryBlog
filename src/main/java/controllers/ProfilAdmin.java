/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaïs GENIN
 */
@WebServlet("/profilAdmin")
public class ProfilAdmin extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Utilisateur user = (Utilisateur) req.getSession().getAttribute("user");
            int idUtilisateur = 1;
            if (user != null) {
                idUtilisateur = user.getId();
            }
            req.getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(req, resp);
        }

}
