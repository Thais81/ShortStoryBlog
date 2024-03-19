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
        super("commentaire");

    }

    @Override
    protected Commentaire createObject(ResultSet rs) throws SQLException {
        Commentaire obj = new Commentaire();
        obj.setId_Commentaire(rs.getInt("id_Commentaire" + table));
        obj.setId_Utilisateur(DAOFactory.getUtilisateurDAO().read(rs.getInt("id_Utilisateur")));
        obj.setContenu(rs.getString("contenu"));
        obj.setDate_publication(rs.getTimestamp("date_publication"));
        obj.setEtat(rs.getString("etat"));
        return obj;
    }

    @Override
    public void save(Commentaire obj) {
        if (obj.getId_Commentaire() == null) {
            create(obj);
        } else {
            update(obj);
        }
    }

    @Override
    public Commentaire read(Integer id) {
        Commentaire obj = null;
        String sql = "SELECT * FROM " + table + " WHERE id_" + table + "=?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                obj = createObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors de la lecture : " + ex.getMessage());
        }
        return obj;
    }

    @Override
    protected void create(Commentaire obj) {
        String sql = "INSERT INTO " + table
                + " (contenu, date_publication, id_Utilisateur) VALUES (?, ?, ?)";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getContenu());
            pstmt.setTimestamp(2, obj.getDate_publication());
            pstmt.setInt(3, obj.getId_Utilisateur().getId());
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
                + " SET contenu=?, date_publication=?, id_Utilisateur=? WHERE id_" + table + "=?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, obj.getContenu());
            pstmt.setTimestamp(2, obj.getDate_publication());
            pstmt.setInt(3, obj.getId_Utilisateur().getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM " + table + " WHERE id_" + table + "=?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors du delete : " + ex.getMessage());
        }
    }

    @Override
    public Collection<Commentaire> list() {
        ArrayList<Commentaire> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY date_publication DESC";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Commentaire obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, "Erreur lors du listage : ", ex.getMessage());
        }
        return list;
    }
    
    @Override
        public int count() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS c FROM " + table;
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                count = rs.getInt("c");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors du comptage : ", ex.getMessage());
        }
        return count;
    }

}
