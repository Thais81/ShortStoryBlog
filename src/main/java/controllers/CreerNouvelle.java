

package controllers;


import forms.NouvelleFormChecker;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevinh
 */
@WebServlet("/profil/creer_nouvelle")
public class CreerNouvelle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/creerNouvelle.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        NouvelleFormChecker fc = new NouvelleFormChecker(req);
        fc.checkForm();
        if (fc.getErrors().isEmpty()) {
            req.setAttribute("message", "Votre nouvelle est bien enregistrée");
            req.getRequestDispatcher("/WEB-INF/creerNouvelle.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMsg", "Votre formulaire comporte des erreurs.");
            req.getRequestDispatcher("/WEB-INF/creerNouvelle.jsp").forward(req, resp);
        }
    }



}
