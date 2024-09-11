package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "professeur_matiere")
public class Professeur_matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professeur_matiere", nullable = false)
    private Integer id_professeur_matiere;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur_id;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere_id;

    @ManyToOne
    @JoinColumn(name = "id_cours")
    private Cours id_cours;

    public Integer getId_professeur_matiere() {
        return id_professeur_matiere;
    }

    public Cours getId_cours() {
        return id_cours;
    }

    public void setId_cours(Cours id_cours) {
        this.id_cours = id_cours;
    }

    public void setId_professeur_matiere(Integer id_professeur_matiere) {
        this.id_professeur_matiere = id_professeur_matiere;
    }

    public Professeur getProfesseur_id() {
        return professeur_id;
    }

    public void setProfesseur_id(Professeur professeur_id) {
        this.professeur_id = professeur_id;
    }

    public Matiere getMatiere_id() {
        return matiere_id;
    }

    public void setMatiere_id(Matiere matiere_id) {
        this.matiere_id = matiere_id;
    }
}
