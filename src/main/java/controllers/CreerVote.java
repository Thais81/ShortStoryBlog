/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DAOFactory;
import dao.VoteDAO;
import entities.Utilisateur;
import entities.Vote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caroline Bergé
 */
@WebServlet("/vote")
public class CreerVote extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres de la requête
        int id_Nouvelle = Integer.parseInt(request.getParameter("id_Nouvelle"));
        String qualite = request.getParameter("qualite");

        // Vérifier si l'utilisateur est connecté (vous devez implémenter la logique d'authentification)
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
        if (utilisateur == null) {
            // Rediriger l'utilisateur vers la page de connexion s'il n'est pas connecté
            response.sendRedirect(request.getContextPath() + "/connexion");
            return;
        }

        // Créer un objet Vote avec les données de la requête
        Vote vote = new Vote();
        vote.setIdNouvelle(id_Nouvelle);
        vote.setIdUtilisateur(utilisateur.getId());

        // Convertir la qualité du vote en int
        int qualiteInt = qualite.equalsIgnoreCase("positif") ? 1 : -1;
        vote.setQualite(qualiteInt);

        // Enregistrer le vote dans la base de données
        VoteDAO voteDAO = DAOFactory.getVoteDAO();
        voteDAO.create(vote);

        // Rediriger l'utilisateur vers la page d'accueil ou vers la page de la nouvelle votée
        response.sendRedirect(request.getContextPath() + "/accueil");
    }
}
