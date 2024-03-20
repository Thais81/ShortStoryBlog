/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Nouvelle to edit this template
 */
package entities;

import java.sql.Timestamp;

/**
 *
 * @author Thaïs GENIN
 */
public class Nouvelle implements Identifiable {

    private Integer id_Nouvelle;
    private String titre;
    private String descriptif;
    private String contenu;
    private Timestamp date_publication;
    private Utilisateur Utilisateur;

    public Integer getId_Nouvelle() {
        return id_Nouvelle;
    }

    public void setId_Nouvelle(Integer id_Nouvelle) {
        this.id_Nouvelle = id_Nouvelle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(Timestamp date_publication) {
        this.date_publication = date_publication;
    }

    public Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.Utilisateur = Utilisateur;
    }

    @Override
    public Integer getId() {
        return id_Nouvelle;
    }

    @Override
    public void setId(Integer id) {
        this.id_Nouvelle = id_Nouvelle;
    }
}
