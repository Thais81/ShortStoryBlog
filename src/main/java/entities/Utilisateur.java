package entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Caroline Bergé
 */
@SuppressWarnings("serial")
public class Utilisateur implements Identifiable, Serializable {

    private Integer id;
    private String pseudo;
    private String mot_de_passe;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilisateur{");
        sb.append("id=").append(id);
        sb.append(", pseudo=").append(pseudo);
        sb.append(", mot_de_passe=").append(mot_de_passe);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.pseudo);
        hash = 29 * hash + Objects.hashCode(this.mot_de_passe);
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
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        if (!Objects.equals(this.mot_de_passe, other.mot_de_passe)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }



    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
