/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import dao.DAOFactory;
import entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Caroline Bergé
 */
public class ProfilFormChecker extends FormChecker<Utilisateur> {

    private final int MIN_PWD_LENGTH = 5;
    //private final int MIN_LOGIN_LENGTH = 3;

    public ProfilFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Utilisateur checkForm() {


        // hydrater le bean avec les données du formulaire
        String mot_de_passe = request.getParameter("mot_de_passe");
        String newMdp = request.getParameter("newMdp");
        String verif = request.getParameter("verif");
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

        if (!user.getMot_de_passe().equals(mot_de_passe)) {
            setError(mot_de_passe, "Mot de passe incorrect");
        }
        if (newMdp.length() < MIN_PWD_LENGTH) {
            setError(newMdp, "Ce champ doit faire au moins "
                    + MIN_PWD_LENGTH + " lettres.");
        }
        if (!newMdp.equals(verif)) {
            setError(verif, "Les mots de passe ne concordent pas.");
        }
        if (errors.isEmpty()) {
            user.setMot_de_passe(newMdp);
            DAOFactory.getUtilisateurDAO().update(user);
        }
        request.setAttribute("errors", errors);
        request.setAttribute("bean", user);
        return user;
    }

}
