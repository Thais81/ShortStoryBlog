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
public final class MariadbConnection {

    private static Connection connection;

    private MariadbConnection() {
    }

    /**
     * Retourne un singleton de connexion, ferme le programme si ça se passe mal
     *
     * @return un objet Connection vers la DB
     */
    public static Connection getInstance() {
        if (connection == null) {
// Se connecter à la DB
// API JDBC : Java DataBase Connectivity
            String url = ("jdbc:mariadb://wp.ldnr.fr:3306/cda202302_jee2");
            try {
                connection = DriverManager.getConnection(url, "cda202302_jee2", "Garbure2024"); //Code apparent à faire disparaitre
            } catch (SQLException ex) {
                Logger.getLogger(MariadbConnection.class.getName()).log(Level.SEVERE, null, ex);
//si ça se passe mal on sort
                System.exit(1);
            }
        }
        return connection;
    }

}
