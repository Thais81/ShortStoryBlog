/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DAOFactory;
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

        Utilisateur user = (Utilisateur) req.getSession().getAttribute("user");
        int idUtilisateur = 0;
        if (user != null) {
            idUtilisateur = user.getId();
        }

        req.setAttribute("nouvelles", DAOFactory.getNouvelleDAO().listNouvellesUtilisateur(idUtilisateur));
        req.getRequestDispatcher("/WEB-INF/profil.jsp").forward(req, resp);
    }

}
