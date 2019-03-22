/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Dell
 */
@Entity
public class TypeAbonnement implements Serializable {

    @OneToOne(mappedBy = "typeAbonnement", cascade = CascadeType.REMOVE)
    private Abonnement abonnement;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;
    @OneToMany(mappedBy = "typeAbonnement")
    private List<Facture> factures;

    public TypeAbonnement() {
    }

    public TypeAbonnement(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }
    
    

    public TypeAbonnement(Abonnement abonnement, Long id, String nom, double prix) {
        this.abonnement = abonnement;
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public TypeAbonnement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeAbonnement)) {
            return false;
        }
        TypeAbonnement other = (TypeAbonnement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   nom + "";
    }

 
    
}
