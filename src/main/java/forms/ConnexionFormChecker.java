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
public class ConnexionFormChecker extends FormChecker<Utilisateur> {


    public ConnexionFormChecker(HttpServletRequest request) {
        super(request);
    }


    @Override
    public Utilisateur checkForm() {
        Utilisateur obj = new Utilisateur();

        // hydrater le bean avec les données du formulaire
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        obj.setLogin(login);
        obj.setPassword(password);

        // Vérifier les données du formulaire
        //Vérifier si les champs sont remplis
        if (login.trim().length() == 0) {
            setError("login", "ce champ doit etre rempli.");
        }
        if (password.length() == 0) {
            setError("password", "ce champ doit etre rempli.");
        }
        if (errors.isEmpty()) {
            Utilisateur read = new UtilisateurDAO().read(login);

            if (read == null || !password.equals(read.getPassword())) {
                setError("login", "Ces informations ne nous permettent pas de vous connecter");
            }
            if (read != null) {
                obj.setId(read.getId());
            }

        }
        //associer les messages d'erreur et le bean à la requet
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }

}
