package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formation", nullable = false)
    private Integer id_formation;

    @Column(name = "nom_formation")
    private String nom_formation;

    public Integer getId_formation() {
        return id_formation;
    }

    public void setId_formation(Integer id_formation) {
        this.id_formation = id_formation;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }
}
