/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Dell
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String password;
    private String nom;
    private String prenom;
    private String sexe;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeNaissance;
    private String nationalite;
    @OneToMany(mappedBy = "client")
    private List<Abonnement> abonnements;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Agence agence;
    @OneToMany(mappedBy = "client")
    private List<Achat> achats;
    @OneToMany(mappedBy = "client")
    private List<Facture> factures;

    public Client() {
    }

    public Client(Long id, String nom, String prenom, String sexe, int typeClient, Date dateDeNaissance, String raisonSociale, double capital, String nationalite, List<Abonnement> abonnements, Agence agence, List<Achat> achats, List<Facture> factures) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateDeNaissance = dateDeNaissance;
        this.nationalite = nationalite;
        this.abonnements = abonnements;
        this.agence = agence;
        this.achats = achats;
        this.factures = factures;
    }
    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchatss(List<Achat> achats) {
        this.achats = achats;
       
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
    
    
      public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", dateDeNaissance=" + dateDeNaissance + ", nationalite=" + nationalite + ", abonnements=" + abonnements + ", agence=" + agence + ", achats=" + achats + ",factures=" + factures +'}';
    }

}
