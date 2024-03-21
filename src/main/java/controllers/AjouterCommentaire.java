package controllers;


import entities.Commentaire;
import forms.CommentaireFormChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jopaups
 */
@WebServlet("/ajoutercommentaire")
public class AjouterCommentaire extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("utilisateur") != null) {
            req.getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/accueil");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentaireFormChecker cfc = new CommentaireFormChecker(req);
        Commentaire com = cfc.checkForm();
        if (cfc.getErrors().isEmpty()) {
            req.setAttribute("msg", "Votre commentaire a bien été ajouté!");
        } else {
            req.setAttribute("msgerror", "Votre commentaire n'a pas pu être ajouté!");
        }
        req.getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(req, resp);
    }

}
