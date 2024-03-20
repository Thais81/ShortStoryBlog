/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jopaups
 */
public final class MariadbConnexion {

    private static Connection connexion;

    private MariadbConnexion() {
    }

    /**
     * Retourne un singleton de connexion, ferme le programme si ça se passe mal
     *
     * @return un objet Connection vers la DB
     */
    public static Connection getInstance() {
        if (connexion == null) {
// Se connecter à la DB
// API JDBC : Java DataBase Connectivity
            String url = ("jdbc:mariadb://wp.ldnr.fr:3306/cda202302_jee2");
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connexion = DriverManager.getConnection(url, "cda202302_jee2", "Garbure2024"); //Code apparent à faire disparaitre
            } catch (SQLException ex) {
                Logger.getLogger(MariadbConnexion.class.getName()).log(Level.SEVERE, null, ex);
//si ça se passe mal on sort
                System.exit(1);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MariadbConnexion.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(2);
            }
        }
        return connexion;
    }

}
