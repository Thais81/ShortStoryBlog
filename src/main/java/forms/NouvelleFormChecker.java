

package forms;

import dao.DAOFactory;
import entities.Nouvelle;
import entities.Utilisateur;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kevinh
 */
public class NouvelleFormChecker extends FormChecker<Nouvelle> {

    private final String TITLE_FIELD = "titre";
    private final String DESCRIPTIF_FIELD = "descriptif";
    private final String CONTENT_FIELD = "contenu";
//    private final int MIN_TITLE_LENGTH = 5;
//    private final int MIN_CONTENT_LENGTH = 10;

    public NouvelleFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Nouvelle checkForm() {
        Nouvelle obj = new Nouvelle();
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
        //récupérer contenu
        String titre = getParameter(TITLE_FIELD);
        String contenu = getParameter(CONTENT_FIELD);
        String descriptif = getParameter(DESCRIPTIF_FIELD);
        //valeur Bean
        obj.setId_Utilisateur(utilisateur);
        obj.setContenu(contenu);
        obj.setTitre(titre);
        obj.setDescriptif(descriptif);
        obj.setDate_publication(Timestamp.valueOf(LocalDateTime.now()));
//        if (titre.trim().length() < MIN_TITLE_LENGTH) {
//            setError(TITLE_FIELD, "Ce champs doit faire au moins" + MIN_CONTENT_LENGTH + "lettres.");
//
//        }
//        if (titre.trim().length() < MIN_CONTENT_LENGTH) {
//            setError(CONTENT_FIELD, "Ce champs doit faire au moins" + MIN_CONTENT_LENGTH + "lettres.");
//
//        }
        if (errors.isEmpty()) {
            DAOFactory.getNouvelleDAO().save(obj);
        }
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }


}
