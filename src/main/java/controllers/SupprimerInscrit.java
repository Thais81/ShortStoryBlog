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
@WebServlet("/admin/supprimer_inscrit")
public class SupprimerInscrit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id_utilisateur"));
            if (id != 1) {
                DAOFactory.getUtilisateurDAO().delete(id);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/inscrits");
        } catch (NumberFormatException ex) {
            resp.sendError(403);
        }

    }

}
