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
    private Nouvelle id_Nouvelle;
    private Utilisateur id_Utilisateur;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id_Commentaire);
        hash = 17 * hash + Objects.hashCode(this.contenu);
        hash = 17 * hash + Objects.hashCode(this.date_publication);
        hash = 17 * hash + Objects.hashCode(this.etat);
        hash = 17 * hash + Objects.hashCode(this.id_Nouvelle);
        hash = 17 * hash + Objects.hashCode(this.id_Utilisateur);
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
        if (!Objects.equals(this.date_publication, other.date_publication)) {
            return false;
        }
        if (!Objects.equals(this.id_Nouvelle, other.id_Nouvelle)) {
            return false;
        }
        return Objects.equals(this.id_Utilisateur, other.id_Utilisateur);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commentaire{");
        sb.append("id_Commentaire=").append(id_Commentaire);
        sb.append(", contenu=").append(contenu);
        sb.append(", date_publication=").append(date_publication);
        sb.append(", etat=").append(etat);
        sb.append(", id_Nouvelle=").append(id_Nouvelle);
        sb.append(", id_Utilisateur=").append(id_Utilisateur);
        sb.append('}');
        return sb.toString();
    }



    @Override
    public Integer getId() {
        return id_Commentaire;
    }

    @Override
    public void setId(Integer id) {
        this.id_Commentaire = id;
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

    public Nouvelle getId_Nouvelle() {
        return id_Nouvelle;
    }

    public void setId_Nouvelle(Nouvelle id_Nouvelle) {
        this.id_Nouvelle = id_Nouvelle;
    }

    public Utilisateur getId_Utilisateur() {
        return id_Utilisateur;
    }

    public void setId_Utilisateur(Utilisateur id_Utilisateur) {
        this.id_Utilisateur = id_Utilisateur;
    }


}