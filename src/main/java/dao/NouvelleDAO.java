/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.NouvelleDAO to edit this template
 */
package dao;

import entities.Nouvelle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Thaïs GENIN
 */
public class NouvelleDAO extends DAO<Nouvelle> {

    public NouvelleDAO() {
        super("Nouvelle");
    }

    @Override
    protected Nouvelle createObject(ResultSet rs) throws SQLException {
        Nouvelle nouv = new Nouvelle();
        nouv.setId_Nouvelle(rs.getInt("id_Nouvelle"));
        nouv.setTitre(rs.getString("titre"));
        nouv.setContenu(rs.getString("contenu"));
        nouv.setDescriptif(rs.getString("descriptif"));
        nouv.setDate_publication(rs.getTimestamp("date_publication"));
        nouv.setId_Utilisateur(DAOFactory.getUtilisateurDAO().read(rs.getInt("id_Utilisateur")));
        return nouv;
    }

    @Override
    public void create(Nouvelle nouv) {
        String sql = "INSERT INTO " + table + " (titre, descriptif, contenu, date_publication,id_Utilisateur) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nouv.getTitre());
            pstmt.setString(2, nouv.getDescriptif());
            pstmt.setString(3, nouv.getContenu());
            pstmt.setTimestamp(4, nouv.getDate_publication());
            pstmt.setInt(5, nouv.getId_Utilisateur().getId());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet autoGeneratedKeys = pstmt.getGeneratedKeys();
                autoGeneratedKeys.first();
                int id = autoGeneratedKeys.getInt(1);
                nouv.setId(id);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'insertion : " + ex.getMessage());
        }
    }

    @Override
    protected void update(Nouvelle nouv) {
        String sql = "UPDATE " + table
                + "titre=?," + "contenu=?," + "date_publication=?,"
                + "descriptif=?, WHERE id_" + table + "=?";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {

            pstmt.setString(1, nouv.getTitre());
            pstmt.setString(2, nouv.getContenu());
            pstmt.setTimestamp(3, nouv.getDate_publication());
            pstmt.setString(4, nouv.getDescriptif());
            pstmt.setInt(5, nouv.getId());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'update : " + ex.getMessage());
        }
    }

    public Collection<Nouvelle> listLastN(int n) {
        ArrayList<Nouvelle> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY date_publication DESC LIMIT ?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, n);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Nouvelle obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors du listage : " + ex.getMessage());
        }
        return list;

    }
    public Collection<Nouvelle> listNouvellesUtilisateur(int idUtilisateur) {
        ArrayList<Nouvelle> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " WHERE id_Utilisateur=?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, idUtilisateur);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Nouvelle obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors du listage : " + ex.getMessage());
        }
        return list;

    }

    public List<Nouvelle> VotesNouvelle() {
        List<Nouvelle> nouvelles = new ArrayList<>();
        String sql = "SELECT Nouvelle.*, COUNT(Vote.id_Nouvelle) AS nombre_votes "
                + "FROM Nouvelle "
                + "LEFT JOIN Vote ON Nouvelle.id = Vote.id_Nouvelle "
                + "GROUP BY Nouvelle.id";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Nouvelle nouvelle = createObject(rs);
                nouvelles.add(nouvelle);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la récupération des nouvelles avec votes : " + ex.getMessage());
        }
        return nouvelles;
    }

    public List<Nouvelle> getNouvellesWithScores() {
        List<Nouvelle> nouvelles = new ArrayList<>();
        String sql = "SELECT Nouvelle.*, COUNT(Vote.id_Nouvelle) AS nombre_votes "
                + "FROM Nouvelle "
                + "LEFT JOIN Vote ON Nouvelle.id_Nouvelle = Vote.id_Nouvelle "
                + "GROUP BY Nouvelle.id_Nouvelle";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Nouvelle nouvelle = createObject(rs);
                nouvelles.add(nouvelle);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la récupération des nouvelles avec votes : " + ex.getMessage());
        }
        return nouvelles;
    }
}
