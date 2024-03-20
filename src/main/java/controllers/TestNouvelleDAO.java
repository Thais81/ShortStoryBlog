

package controllers;
import dao.DAOFactory;
import entities.Nouvelle;
import dao.NouvelleDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevinh
 */
@WebServlet("/testnouv")
public class TestNouvelleDAO extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NouvelleDAO ndao = new NouvelleDAO();
//        Nouvelle n = ndao.read(13);
//        System.out.println("n = " + n);
        Nouvelle nouv = new Nouvelle();

////        nouv.setId_Utilisateur(DAOFactory.getUtilisateurDAO().read(2));
////        nouv.setTitre("etetet");
////        nouv.setDescriptif("egdoklhdfgdf");
////        nouv.setContenu("seofjzefkzejfhserl");
////        nouv.setDate_publication(Timestamp.from(Instant.now()));
////        System.out.println("nouv = " + nouv);
////        ndao.save(nouv);
////        System.out.println("nouv = " + nouv);
////        nouv.setContenu("texte modif");
////        ndao.save(nouv);
////        System.out.println("nouv = " + nouv);
//        ndao.delete(nouv.getId());
//        System.out.println("nouvelle supprimée");
    }


}
