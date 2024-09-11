package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne", nullable = false)
    private Integer id_personne;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre id_genre;

    public Genre getId_genre() {
        return id_genre;
    }

    public void setId_genre(Genre id_genre) {
        this.id_genre = id_genre;
    }

    public Integer getId_personne() {
        return id_personne;
    }

    public void setId_personne(Integer id_personne) {
        this.id_personne = id_personne;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
