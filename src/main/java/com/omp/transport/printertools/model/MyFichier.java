package com.omp.transport.printertools.model;

import javax.persistence.*;


@Entity
@Table(name = "Fichier")
public class MyFichier {

    @Id
    @GeneratedValue(generator = "Seq_fich", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Seq_fich", sequenceName = "fichiers_seq", allocationSize=1)
    private Long id_fichier;
    @Lob
    @Column(name = "FICHIER_CONTENU")
    private byte[] fichier_contenu;
    @Lob
    @Column(name = "CONTFICHIER")
    private byte[] contfichier;

    public MyFichier() {
    }

    public MyFichier(Long id_fichier, byte[] fichier_contenu) {
        this.id_fichier = id_fichier;
        this.fichier_contenu = fichier_contenu;
    }

    public Long getId_fichier() {
        return id_fichier;
    }

    public void setId_fichier(Long id_fichier) {
        this.id_fichier = id_fichier;
    }

    public byte[] getFichier_contenu() {
        return fichier_contenu;
    }

    public void setFichier_contenu(byte[] fichier_contenu) {
        this.fichier_contenu = fichier_contenu;
    }

    public byte[] getContfichier() {
        return contfichier;
    }

    public void setContfichier(byte[] contfichier) {
        this.contfichier = contfichier;
    }

    @Override
    public String toString() {
        return "MyFichier{" +
                "id_fichier=" + id_fichier +
                ", fichier_contenu=" + fichier_contenu +
                '}';
    }
}
