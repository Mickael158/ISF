package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere", nullable = false)
    private Integer id_matiere;

    @Column(name = "nom_matiere")
    private String nom_matiere;

    @Column(name = "coeff")
    private int coeff;

    public Integer getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(Integer id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
}
