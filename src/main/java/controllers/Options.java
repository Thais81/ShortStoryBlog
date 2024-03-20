/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DAOFactory;
import entities.Utilisateur;
import forms.ChangerMDPFormChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amelie Solanas Pruvost
 */
@WebServlet("/profil/options")
public class Options extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/options.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChangerMDPFormChecker fc = new ChangerMDPFormChecker(req);
        Utilisateur obj = fc.checkForm();
        if (fc.getErrors().isEmpty()) {
            req.setAttribute("change", "Votre mot de passe a bien été modifié!");
        }
        req.getRequestDispatcher("/WEB-INF/options.jsp").forward(req, resp);
    }

}
