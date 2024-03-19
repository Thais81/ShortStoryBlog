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
 * @author Caroline Bergé
 */
public class MariaDBConnexion {
    private static Connection connection;

    private MariaDBConnexion() { // constructeur privee pour interdire d'instancier la classe

    }

    /**
     * Retourne un singleton de connexion
     *
     * @return un objet Connection veres la DB Singleton meme objet toujours
     * retourné
     */
    public static Connection getInstance() {

        if (connection == null) {
            String url = String.format("%s://%s:%s/%s", "jdbc:mariadb", "wp.ldnr.fr", "3306", "cda202302_jee2");

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(url, "cda202302_jee2", "Garbure2024");

            } catch (SQLException ex) {
                Logger.getLogger(MariaDBConnexion.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MariaDBConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MariaDBConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
