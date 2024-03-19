/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.NouvelleDAO to edit this template
 */
package dao;

import entities.Nouvelle;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thaïs GENIN
 */
public class NouvelleDAO extends DAO<NouvelleDAO> {

    public NouvelleDAO() {
        super("nouvelle");
    }

@Override
protected Nouvelle createObject(ResultSet rs) throws SQLException {
        Nouvelle nouv = new Nouvelle();
        nouv.setId_Nouvelle(rs.getInt("id_Nouvelle"));
        nouv.setTitre(rs.getString("titre"));
        nouv.setContenu(rs.getString("contenu"));
        nouv.setDate_publication(rs.getTimestamp("date_publication"));
        nouv.setPseudo(DAOFactory.getNouvelleDAO().read(rs.getInt("pseudo")));
        return nouv;
    }

    @Override
    public void create(Nouvelle obj) {
        String sql = "INSERT INTO " + table + " (login, pwd) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getLogin());
            pstmt.setString(2, obj.getPassword());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet autoGeneratedKeys = pstmt.getGeneratedKeys();
                autoGeneratedKeys.first();
                int id = autoGeneratedKeys.getInt(1);
                obj.setId(id);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'insertion : " + ex.getMessage());
        }
    }
//
//    @Override
//    public void update(Nouvelle obj) {
//        String sql = "UPDATE " + table + " SET id_role=?, login=?, pwd=? WHERE id_" + table + "=?";
//        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//            pstmt.setString(2, obj.getLogin());
//            pstmt.setString(3, obj.getPassword());
//            pstmt.setInt(4, obj.getId());
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            System.err.println("Erreur lors de l'update : " + ex.getMessage());
//        }
//    }
//
////@Override
//    public Nouvelle read(String login) {
//        Nouvelle obj = null;
//        String sql = "SELECT * FROM " + table + " WHERE login=?";
//        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//            pstmt.setString(1, login);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.first()) {
//                obj = createObject(rs);
//            }
//        } catch (SQLException ex) {
//            System.err.println("Erreur lors de la lecture : " + ex.getMessage());
//        }
//        return obj;
//    }
//}
