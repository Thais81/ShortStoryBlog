/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import dao.DAOFactory;
import entities.Commentaire;
import entities.Nouvelle;
import entities.Utilisateur;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jopaups
 */
public class CommentaireFormChecker extends FormChecker<Commentaire> {

    public CommentaireFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Commentaire checkForm() {
        Commentaire obj = new Commentaire();

        // hydrater le bean avec les données du formulaire
        String contenu = request.getParameter("contenu");
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");



        //valeur Bean
        obj.setId_Utilisateur(utilisateur);
        obj.setDate_publication(Timestamp.valueOf(LocalDateTime.now()));
        obj.setId_Nouvelle(Integer.valueOf(request.getParameter()));
        obj.setContenu(contenu);
        // Vérifier les données du formulaire
        //Vérifier si les champs sont remplis
        if (contenu == null || contenu.trim().length() == 0) {
            setError("contenu", "ce champ doit être rempli.");
        } else {
        }

        if (errors.isEmpty()) {
            DAOFactory.getCommentaireDAO().save(obj);
        }

        //associer les messages d'erreur et le bean à la requet
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }

}
