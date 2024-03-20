/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DAOFactory;
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
@WebServlet("/profil/supprimermoncompte")
public class SupprimerMonCompte extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id_utilisateur"));
            DAOFactory.getUtilisateurDAO().delete(id);
            resp.sendRedirect(req.getContextPath() + "/profil/options");
        } catch (NumberFormatException ex) {
            resp.sendError(403);
        }
    }

}
