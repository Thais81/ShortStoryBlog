/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import Helpers.PasswordAuthentication;
import dao.DAOFactory;
import dao.UtilisateurDAO;
import entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Caroline Bergé
 */
public class ConnexionFormChecker extends FormChecker<Utilisateur> {


    public ConnexionFormChecker(HttpServletRequest request) {
        super(request);
    }


    @Override
    public Utilisateur checkForm() {
        Utilisateur obj = new Utilisateur();

        // hydrater le bean avec les données du formulaire
        String pseudo = request.getParameter("pseudo");
        String mot_de_passe = request.getParameter("mot_de_passe");
        obj.setPseudo(pseudo);
        obj.setMot_de_passe(mot_de_passe);

        // Vérifier les données du formulaire
        //Vérifier si les champs sont remplis
        if (pseudo.trim().length() == 0) {
            setError("pseudo", "ce champ doit etre rempli.");
        }
        if (mot_de_passe.length() == 0) {
            setError("mot_de_passe", "ce champ doit etre rempli.");
        }
        if (errors.isEmpty()) {
            Utilisateur read = DAOFactory.getUtilisateurDAO().read(pseudo);
            PasswordAuthentication pa = new PasswordAuthentication();
            if (read == null || !pa.authenticate(mot_de_passe.toCharArray(), read.getMot_de_passe())) {
                setError("pseudo", "Ces informations ne nous permettent pas de vous connecter");
            }
            if (read != null) {
                obj.setId(read.getId());
                obj.setEstActif(read.getEstActif());
            }

        }
        //associer les messages d'erreur et le bean à la requet
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }

}
