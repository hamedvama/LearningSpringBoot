package com.omp.transport.printertools.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ETUDIANT")
public class Etudiant {

    @Id
    private Long matricule;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date date_naiss;

    //private List<Etudiant> voisins = new ArrayList<Etudiant>();

    public Etudiant(Long matricule, String nom, String prenom, Date date_naiss) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
    }

    public Etudiant(Long matricule) {
        this.matricule = matricule;
    }

    public Etudiant() {
    }

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
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

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "matricule=" + matricule +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naiss=" + date_naiss +
                '}';
    }
}

