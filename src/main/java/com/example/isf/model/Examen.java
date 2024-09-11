package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "examen")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen", nullable = false)
    private Integer id_examen;

    @Column(name = "date_debut")
    private Date date_debut;


    @Column(name = "date_fin")
    private Date date_fin;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours_id;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre_id;

    public Integer getId_examen() {
        return id_examen;
    }

    public void setId_examen(Integer id_examen) {
        this.id_examen = id_examen;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Cours getCours_id() {
        return cours_id;
    }

    public void setCours_id(Cours cours_id) {
        this.cours_id = cours_id;
    }

    public Semestre getSemestre_id() {
        return semestre_id;
    }

    public void setSemestre_id(Semestre semestre_id) {
        this.semestre_id = semestre_id;
    }
}
