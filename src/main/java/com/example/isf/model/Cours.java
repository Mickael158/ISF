package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cours", nullable = false)
    private Integer id_cours;

    @Column(name = "date_debut")
    private Date date_debut;


    @Column(name = "date_fin")
    private Date date_fin;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion_id;

    @ManyToOne
    @JoinColumn(name = "id_niveaux")
    private Niveaux id_niveaux;

    public Integer getId_cours() {
        return id_cours;
    }

    public void setId_cours(Integer id_cours) {
        this.id_cours = id_cours;
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

    public Promotion getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Promotion promotion_id) {
        this.promotion_id = promotion_id;
    }

    public Niveaux getId_niveaux() {
        return id_niveaux;
    }

    public void setId_niveaux(Niveaux id_niveaux) {
        this.id_niveaux = id_niveaux;
    }
}
