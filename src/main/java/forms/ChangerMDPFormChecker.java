/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import Helpers.PasswordAuthentication;
import dao.DAOFactory;
import entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amelie Solanas Pruvost
 */
public class ChangerMDPFormChecker extends FormChecker<Utilisateur> {

    private final int MIN_MDP_LENGTH = 12;
    private final String MDP_FIELD = "mdp";
    private final String NOUV_MDP_FIELD = "next";
    private final String VERIF_FIELD = "verif";

    public ChangerMDPFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Utilisateur checkForm() {
        String mdp = getParameter(MDP_FIELD);
        String nouv_mdp = getParameter(NOUV_MDP_FIELD);
        String verif = getParameter(VERIF_FIELD);
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

        if (!user.getMot_de_passe().equals(mdp)) {
            setError(MDP_FIELD, "Mot de passe incorrect");
        }
        if (nouv_mdp.length() < MIN_MDP_LENGTH) {
            setError(NOUV_MDP_FIELD, "Votre mot de passe doit faire au minimum"
                    + MIN_MDP_LENGTH + " caractères!");
        }
        if (!nouv_mdp.equals(verif)) {
            setError(VERIF_FIELD, "Les mots de passe ne sont pas identiques!");
        }
        if (errors.isEmpty()) {
            // Hasher le nouveau mot de passe
            PasswordAuthentication pa = new PasswordAuthentication();
            String hashedPassword = pa.hash(nouv_mdp.toCharArray());

            // Mettre à jour le mot de passe dans l'objet utilisateur
            user.setMot_de_passe(hashedPassword);

            // Mettre à jour le mot de passe dans la base de données
            DAOFactory.getUtilisateurDAO().save(user);
        }
        request.setAttribute("errors", errors);
        request.setAttribute("bean", user);
        return user;
    }

}
