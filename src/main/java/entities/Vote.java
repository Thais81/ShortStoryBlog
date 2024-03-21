/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Caroline Bergé
 */
public class Vote implements Identifiable {

    private int idNouvelle; // Identifiant de la nouvelle associée
    private int idUtilisateur; // Identifiant de l'utilisateur ayant voté
    private int qualite; // Indique si le vote est positif (true) ou négatif (false)

    // Constructeur, getters et setters


    public int getIdNouvelle() {
        return idNouvelle;
    }

    public void setIdNouvelle(int idNouvelle) {
        this.idNouvelle = idNouvelle;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getQualite() {
        return qualite;
    }

    public void setQualite(int qualite) {
        this.qualite = qualite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        //hash = 59 * hash + this.id;
        hash = 59 * hash + this.idNouvelle;
        hash = 59 * hash + this.idUtilisateur;
        hash = 59 * hash + this.qualite;
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
        final Vote other = (Vote) obj;
        if (this.idNouvelle != other.idNouvelle) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return this.qualite == other.qualite;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vote{");
        // sb.append("id=").append(id);
        sb.append(", idNouvelle=").append(idNouvelle);
        sb.append(", idUtilisateur=").append(idUtilisateur);
        sb.append(", qualite=").append(qualite);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
