package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "note_examen")
public class Note_Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note_examen", nullable = false)
    private Integer id_note_examen;

    @ManyToOne
    @JoinColumn(name = "id_examen")
    private Examen id_examen;

    @ManyToOne
    @JoinColumn(name = "id_professeur_matiere")
    private Professeur_matiere id_professeur_matiere;

    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant id_etudiant;

    @Column(name = "note")
    private double note;

    public Integer getId_note_examen() {
        return id_note_examen;
    }

    public void setId_note_examen(Integer id_note_examen) {
        this.id_note_examen = id_note_examen;
    }

    public Examen getId_examen() {
        return id_examen;
    }

    public Etudiant getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Etudiant id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public void setId_examen(Examen id_examen) {
        this.id_examen = id_examen;
    }

    public Professeur_matiere getId_professeur_matiere() {
        return id_professeur_matiere;
    }

    public void setId_professeur_matiere(Professeur_matiere id_professeur_matiere) {
        this.id_professeur_matiere = id_professeur_matiere;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
