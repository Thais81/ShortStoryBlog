/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import dao.DAOFactory;
import entities.Commentaire;
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

        // Vérifier les données du formulaire
        //Vérifier si les champs sont remplis
        if (contenu.trim().length() == 0) {
            setError("contenu", "ce champ doit etre rempli.");
        }

        if (errors.isEmpty()) {
            DAOFactory.geCommentaireDAO().save(obj);
            }

        //associer les messages d'erreur et le bean à la requet
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }

}
