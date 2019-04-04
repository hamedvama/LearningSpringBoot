package com.omp.transport.printertools.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURS")
public class Cours {
    @Id
    private Long cod_cours;
    private String lib_cours;

    public Cours(Long cod_cours, String lib_cours) {
        this.cod_cours = cod_cours;
        this.lib_cours = lib_cours;
    }

    public Cours(Long cod_cours) {
        this.cod_cours = cod_cours;
    }

    public Cours() {
    }

    public Long getCod_cours() {
        return cod_cours;
    }

    public void setCod_cours(Long cod_cours) {
        this.cod_cours = cod_cours;
    }

    public String getLib_cours() {
        return lib_cours;
    }

    public void setLib_cours(String lib_cours) {
        this.lib_cours = lib_cours;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "cod_cours=" + cod_cours +
                ", lib_cours='" + lib_cours + '\'' +
                '}';
    }
}
