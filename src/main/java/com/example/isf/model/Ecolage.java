package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ecolage")
public class Ecolage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ecolage", nullable = false)
    private Integer id_ecolage;

    @Column(name = "dates")
    private Date dates;

    @Column(name = "prix")
    private double prix;

    @Column(name = "date_payement")
    private Date date_payement;

    @ManyToOne
    @JoinColumn(name = "id_cours")
    private Cours id_cours;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant_id;

    public Integer getId_ecolage() {
        return id_ecolage;
    }

    public void setId_ecolage(Integer id_ecolage) {
        this.id_ecolage = id_ecolage;
    }

    public Date getDates() {
        return dates;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Date getDate_payement() {
        return date_payement;
    }

    public void setDate_payement(Date date_payement) {
        this.date_payement = date_payement;
    }

    public Cours getId_cours() {
        return id_cours;
    }

    public void setId_cours(Cours id_cours) {
        this.id_cours = id_cours;
    }

    public Etudiant getEtudiant_id() {
        return etudiant_id;
    }

    public void setEtudiant_id(Etudiant etudiant_id) {
        this.etudiant_id = etudiant_id;
    }
}
