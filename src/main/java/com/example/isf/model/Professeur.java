package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeur")
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professeur", nullable = false)
    private Integer id_professeur;

    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne id_personne;

    public Integer getId_professeur() {
        return id_professeur;
    }

    public void setId_professeur(Integer id_professeur) {
        this.id_professeur = id_professeur;
    }

    public Personne getId_personne() {
        return id_personne;
    }

    public void setId_personne(Personne id_personne) {
        this.id_personne = id_personne;
    }
}
