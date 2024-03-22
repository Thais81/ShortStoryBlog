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
 * @author Caroline Bergé
 */
public class InscriptionFormChecker extends FormChecker<Utilisateur> {

    private final int MIN_MDP_LENGTH = 12;
    private final int MIN_PSEUDO_LENGTH = 12;

    public InscriptionFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Utilisateur checkForm() {
        Utilisateur obj = new Utilisateur();

        // hydrater le bean avec les données du formulaire
        String pseudo = request.getParameter("pseudo");
        String mot_de_passe = request.getParameter("mot_de_passe");
        String verif = request.getParameter("verif");
        obj.setPseudo(pseudo);
        obj.setMot_de_passe(mot_de_passe);
        obj.setMot_de_passe(verif);
        obj.setEstActif(true);
        // Vérifier les données du formulaire

        if (pseudo.trim().length() < MIN_PSEUDO_LENGTH) {
            setError("pseudo", "Le pseudo doit contenir au minimum 5 caractères avant '@'.");
        } else if (!pseudo.contains("@")) {
            setError("pseudo", "Le pseudo doit contenir un '@', doit etre une adresse mail .");
        }

        if (mot_de_passe.length() < MIN_MDP_LENGTH) {
            setError("mot_de_passe", "ce champ doit etre rempli, doit contenir au minimum 12 caractères.");
        }

        // Vérifier si le champ "verif" correspond au champ "password"
        if (verif.trim().length() == 0) {
            setError("verif", "ce champ doit correspondre au mot de passe .");

        }

        if (!verif.equals(mot_de_passe)) {
            setError("verif", "Le champ de vérification ne correspond pas au mot de passe.");
        }

        if (errors.isEmpty()) {
            Utilisateur read = DAOFactory.getUtilisateurDAO().read(pseudo);

            if (read != null) {
                setError("pseudo", "Cet utilisateur existe. Veuillez vous connecter");
            } else {
                PasswordAuthentication pa = new PasswordAuthentication();
                obj.setMot_de_passe(pa.hash(mot_de_passe.toCharArray()));
                DAOFactory.getUtilisateurDAO().save(obj);
            }
        }
        //associer les messages d'erreur et le bean à la requête
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }
}
