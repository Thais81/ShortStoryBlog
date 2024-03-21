package controllers;

import dao.DAOFactory;
import entities.Nouvelle;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaïs Genin
 */
@WebServlet("/accueil")
public class Accueil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        Collection<Nouvelle> nouvelles = DAOFactory.getNouvelleDAO().listLastN(10);
        Collection<Nouvelle> nouvellesAvecScore = new ArrayList<>();
        for (Nouvelle laNouvelle : nouvelles) {
            double score = DAOFactory.getVoteDAO().calculateScore(laNouvelle.getId());
            laNouvelle.setScore(score);
            nouvellesAvecScore.add(laNouvelle);
        }
        req.setAttribute("nouvelles", DAOFactory.getNouvelleDAO().listLastN(10));
        req.setAttribute("nouvelles", nouvellesAvecScore);
        req.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(req, resp);
    }

}
