package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "niveaux")
public class Niveaux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_niveaux", nullable = false)
    private Integer id_niveaux;

    @Column(name = "nom")
    private String nom;

    public Integer getId_niveaux() {
        return id_niveaux;
    }

    public void setId_niveaux(Integer id_niveaux) {
        this.id_niveaux = id_niveaux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
