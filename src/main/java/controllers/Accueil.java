package controllers;

import dao.DAOFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        req.setAttribute("nouvelles", DAOFactory.getNouvelleDAO().listLastN(10));
        req.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(req, resp);
    }

}
