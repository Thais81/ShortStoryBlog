/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Amelie Solanas Pruvost
 */
public final class DAOFactory {

    private static NouvelleDAO nouvelleDAO;
//    private static VoteDAO voteDAO;
//    private static CommentaireDAO commentaireDAO;
    private static UtilisateurDAO utilisateurDAO;

    private DAOFactory() {

    }

    public static NouvelleDAO getNouvelleDAO() {
        if (nouvelleDAO == null) {
            nouvelleDAO = new NouvelleDAO();
        }
        return nouvelleDAO;
    }
//
//    public static VoteDAO getVoteDAO() {
//        if (voteDAO == null) {
//            voteDAO = new VoteDAO();
//        }
//        return voteDAO;
//    }
//
//    public static CommentaireDAO getCommentaireDAO() {
//        if (commentaireDAO == null) {
//            commentaireDAO = new CommentaireDAO();
//        }
//        return commentaireDAO;
//
//    }

    public static UtilisateurDAO getUtilisateurDAO() {
        if (utilisateurDAO == null) {
            utilisateurDAO = new UtilisateurDAO();
        }
        return utilisateurDAO;
    }

}
