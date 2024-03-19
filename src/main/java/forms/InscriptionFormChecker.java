/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Caroline Bergé
 */

public class InscriptionFormChecker extends FormChecker<Utilisateur> {
    private final int MIN_PWD_LENGTH = 5;
    private final int MIN_LOGIN_LENGTH = 12;

    public InscriptionFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Utilisateur checkForm() {
        Utilisateur obj = new Utilisateur();

        // hydrater le bean avec les données du formulaire
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String verif = request.getParameter("verif");
        obj.setLogin(login);
        obj.setPassword(password);
        //obj.setPassword(verif);
        // Vérifier les données du formulaire

        if (login.trim().length() < MIN_LOGIN_LENGTH) {
            setError("login", "ce champ doit etre rempli.");
        }
        if (password.length() < MIN_PWD_LENGTH) {
            setError("password", "ce champ doit etre rempli.");
        }

        // Vérifier si le champ "verif" correspond au champ "password"
        if (verif.trim().length() == 0) {
            setError("verif", "ce champ doit etre rempli.");

        }

        if (!verif.equals(password)) {
            setError("verif", "Le champ de vérification ne correspond pas au mot de passe.");
        }

        if (errors.isEmpty()) {
            Utilisateur read = new UtilisateurDAO().read(login);
            if (read != null) {
                setError("login", "Cet utilisateur existe. Veuillez vous connecter");
            } else {
                new UtilisateurDAO().create(obj);
            }
        }
        //associer les messages d'erreur et le bean à la requête
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }
}
