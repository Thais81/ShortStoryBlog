package entities;

import java.sql.Timestamp;
import java.util.Objects;



/**
 *
 * @author Jopaups
 */
public class Commentaire implements Identifiable{
    private Integer id_Commentaire;
    private String contenu;
    private Timestamp date_publication;
    private String etat;
    Utilisateur id_Utilisateur;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_Commentaire);
        hash = 29 * hash + Objects.hashCode(this.contenu);
        hash = 29 * hash + Objects.hashCode(this.date_publication);
        hash = 29 * hash + Objects.hashCode(this.etat);
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
        final Commentaire other = (Commentaire) obj;
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.id_Commentaire, other.id_Commentaire)) {
            return false;
        }
        return Objects.equals(this.date_publication, other.date_publication);
    }

    public Integer getId_Commentaire() {
        return id_Commentaire;
    }

    public void setId_Commentaire(Integer id_Commentaire) {
        this.id_Commentaire = id_Commentaire;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
