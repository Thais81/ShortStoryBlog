/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Nouvelle;
import entities.Vote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author Caroline Bergé
 */
public class VoteDAO extends DAO<Vote> {

    public VoteDAO() {
        super("Vote");
    }

    @Override
    protected Vote createObject(ResultSet rs) throws SQLException {
        Vote vote = new Vote();
        vote.setIdNouvelle(rs.getInt("id_Nouvelle"));
        vote.setIdUtilisateur(rs.getInt("id_Utilisateur"));
        vote.setQualite(rs.getInt("qualite"));
        return vote;
    }

    @Override
    public void create(Vote obj) {
        String sql = "INSERT INTO Vote (id_Nouvelle, id_Utilisateur, qualite) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connexion
                    .prepareStatement(
                            sql,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );
            pstmt.setInt(1, obj.getIdNouvelle());
            pstmt.setInt(2, obj.getIdUtilisateur());
            pstmt.setInt(3, obj.getQualite());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erreur lors de la création du vote : " + ex.getMessage());
        }
    }

    @Override
    protected void update(Vote obj) {
        String sql = "UPDATE Vote SET qualite = ? WHERE id_Nouvelle = ? AND id_Utilisateur = ?";
        try {
            PreparedStatement pstmt = connexion
                    .prepareStatement(
                            sql,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );
            pstmt.setInt(1, obj.getQualite());
            pstmt.setInt(2, obj.getIdNouvelle());
            pstmt.setInt(3, obj.getIdUtilisateur());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erreur lors de la mise à jour du vote : " + ex.getMessage());


        }
    }

    public void delete(Vote obj) {
        String sql = "DELETE FROM Vote WHERE id_Nouvelle = ? AND id_Utilisateur = ?";
        try {
            PreparedStatement pstmt = connexion
                    .prepareStatement(sql);
                pstmt.setInt(1, obj.getIdNouvelle());
                pstmt.setInt(2, obj.getIdUtilisateur());

                     int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted == 0) {
                    System.out.println("Aucun enregistrement trouvé pour la suppression");
                } else {
                    System.out.println("Enregistrement supprimé avec succès");
                }
            }catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public List<Vote> VoterNouvelle(int idNouvelle) {
        List<Vote> votes = new ArrayList<>();
        String sql = "SELECT * FROM Vote WHERE id_Nouvelle=?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, idNouvelle);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Vote vote = new Vote();
                vote.setIdNouvelle(rs.getInt("id_Nouvelle"));
                vote.setIdUtilisateur(rs.getInt("id_Utilisateur"));
                vote.setQualite(rs.getInt("qualite"));
                votes.add(vote);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la récupération des votes : " + ex.getMessage());
        }
        return votes;
    }

    public double calculateScore(int idNouvelle) {
        List<Vote> votes = VoterNouvelle(idNouvelle);
        if (votes.isEmpty()) {
            return 0.0;
        }

        int totalVotes = votes.size();
        int positiveVotes = 0;
        for (Vote vote : votes) {
            if (vote.getQualite() == 1) {
                positiveVotes++;
            }
        }

        return ((double) positiveVotes / totalVotes) * 100.0;

    }

}    
