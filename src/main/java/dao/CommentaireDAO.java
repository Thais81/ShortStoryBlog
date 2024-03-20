package dao;

import entities.Commentaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jopaups
 */
public class CommentaireDAO extends DAO<Commentaire> {

    public CommentaireDAO() {
        super("Commentaire");
    }

    @Override
    protected Commentaire createObject(ResultSet rs) throws SQLException {
        Commentaire obj = new Commentaire();
        obj.setId_Commentaire(rs.getInt("id_" + table));
        obj.setId_Utilisateur(DAOFactory.getUtilisateurDAO().read(rs.getInt("id_Utilisateur")));
        obj.setId_Nouvelle(DAOFactory.getNouvelleDAO().read(rs.getInt("id_Nouvelle")));
        obj.setContenu(rs.getString("contenu"));
        obj.setDate_publication(rs.getTimestamp("date_publication"));
        obj.setEtat(rs.getString("etat"));
        return obj;
    }

    @Override
    protected void create(Commentaire obj) {
        String sql = "INSERT INTO " + table
                + " (contenu, date_publication, id_Nouvelle, id_Utilisateur) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getContenu());
            pstmt.setTimestamp(2, obj.getDate_publication());
            pstmt.setInt(3, obj.getId_Nouvelle().getId());
            pstmt.setInt(4, obj.getId_Utilisateur().getId());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                generatedKeys.first();
                int id = generatedKeys.getInt(1);
                obj.setId_Commentaire(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void update(Commentaire obj) {
        String sql = "UPDATE " + table
                + " SET contenu=?, date_publication=?, id_Nouvelle=?, id_Utilisateur=? WHERE id_" + table + "=?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, obj.getContenu());
            pstmt.setTimestamp(2, obj.getDate_publication());
            pstmt.setInt(3, obj.getId_Nouvelle().getId());
            pstmt.setInt(4, obj.getId_Utilisateur().getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
