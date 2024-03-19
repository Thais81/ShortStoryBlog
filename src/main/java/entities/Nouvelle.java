/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Nouvelle to edit this template
 */
package entities;

import java.sql.Timestamp;
import java.util.Objects;

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
    private Utilisateur id_Utilisateur;

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

    @Override
    public Integer getId() {
        return id_Nouvelle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id_Nouvelle);
        hash = 79 * hash + Objects.hashCode(this.titre);
        hash = 79 * hash + Objects.hashCode(this.descriptif);
        hash = 79 * hash + Objects.hashCode(this.contenu);
        hash = 79 * hash + Objects.hashCode(this.date_publication);
        hash = 79 * hash + Objects.hashCode(this.id_Utilisateur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nouvelle other = (Nouvelle) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.descriptif, other.descriptif)) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.id_Nouvelle, other.id_Nouvelle)) {
            return false;
        }
        if (!Objects.equals(this.date_publication, other.date_publication)) {
            return false;
        }
        return Objects.equals(this.id_Utilisateur, other.id_Utilisateur);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nouvelle{");
        sb.append("id_Nouvelle=").append(id_Nouvelle);
        sb.append(", titre=").append(titre);
        sb.append(", descriptif=").append(descriptif);
        sb.append(", contenu=").append(contenu);
        sb.append(", date_publication=").append(date_publication);
        sb.append(", id_Utilisateur=").append(id_Utilisateur);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        this.id_Nouvelle = id;
    }

    public Utilisateur getId_Utilisateur() {
        return id_Utilisateur;
    }

    public void setId_Utilisateur(Utilisateur id_Utilisateur) {
        this.id_Utilisateur = id_Utilisateur;
    }
}
