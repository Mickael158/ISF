package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prix_ecolage")
public class PrixEcolage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prix_ecolage", nullable = false)
    private Integer id_prix_ecolage;

    @Column(name = "valeur")
    private double valeur;


    @Column(name = "dates")
    private Date dates;

    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveaux id_niveau;

    public Integer getId_prix_ecolage() {
        return id_prix_ecolage;
    }

    public void setId_prix_ecolage(Integer id_prix_ecolage) {
        this.id_prix_ecolage = id_prix_ecolage;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Niveaux getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(Niveaux id_niveau) {
        this.id_niveau = id_niveau;
    }
}
