
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Nouvelle to edit this template
 */
package controllers;

import dao.DAOFactory;
import entities.Commentaire;
import forms.CommentaireFormChecker;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaïs GENIN
 */
@WebServlet("/nouvelle")
public class Nouvelle extends HttpServlet {

    int id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id"));
            entities.Nouvelle nouvelle = DAOFactory.getNouvelleDAO().read(id);
            List<Commentaire> commentaires = (List<Commentaire>) DAOFactory.getCommentaireDAO().listById_Nouvelle(id);
            if (nouvelle == null) {
                throw new IllegalArgumentException();
            } else {
                req.setAttribute("nouvelle", nouvelle);
                req.setAttribute("commentaires", commentaires);
                req.getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(req, resp);
            }
        } catch (IllegalArgumentException ex) {
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentaireFormChecker cfc = new CommentaireFormChecker(req);
        Commentaire com = cfc.checkForm();

        if (cfc.getErrors().isEmpty()) {
            req.setAttribute("msg", "Votre commentaire a bien été ajouté!");
        }
        resp.sendRedirect("/projetJEE/nouvelle?id=" + id);
    }
}
