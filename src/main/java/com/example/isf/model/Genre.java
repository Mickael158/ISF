package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre", nullable = false)
    private Integer id_genre;

    @Column(name = "nom")
    private String nom;

    public Integer getId_genre() {
        return id_genre;
    }

    public void setId_genre(Integer id_genre) {
        this.id_genre = id_genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
