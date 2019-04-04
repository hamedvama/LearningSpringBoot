package com.omp.transport.printertools.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "INSCRIRE")
public class Inscrire {
    @Id
    private Long cod_inscrire;
    private Long matricule;
    private Long cod_cours;
    @Temporal(TemporalType.DATE)
    private Date date_inscription;
    private Long montant_verse;

    public Inscrire() {
    }

    public Inscrire(Long cod_inscrire, Long matricule, Long cod_cours) {
        this.cod_inscrire = cod_inscrire;
        this.matricule = matricule;
        this.cod_cours = cod_cours;
    }

    public Inscrire(Long cod_inscrire, Long matricule, Long cod_cours, Date date_inscription, Long montant_verse) {
        this.cod_inscrire = cod_inscrire;
        this.matricule = matricule;
        this.cod_cours = cod_cours;
        this.date_inscription = date_inscription;
        this.montant_verse = montant_verse;
    }

    public Long getCod_inscrire() {
        return cod_inscrire;
    }

    public void setCod_inscrire(Long cod_inscrire) {
        this.cod_inscrire = cod_inscrire;
    }

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
    }

    public Long getCod_cours() {
        return cod_cours;
    }

    public void setCod_cours(Long cod_cours) {
        this.cod_cours = cod_cours;
    }

    public Date getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    public Long getMontant_verse() {
        return montant_verse;
    }

    public void setMontant_verse(Long montant_verse) {
        this.montant_verse = montant_verse;
    }

    @Override
    public String toString() {
        return "Inscrire{" +
                "cod_inscrire=" + cod_inscrire +
                ", matricule=" + matricule +
                ", cod_cours=" + cod_cours +
                ", date_inscription=" + date_inscription +
                ", montant_verse=" + montant_verse +
                '}';
    }
}
