package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "institut")
public class Institut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Institut", nullable = false)
    private Integer id_institut;

    @Column(name = "Logo")
    private String logo;

    @Column(name = "nom_institut")
    private String nom_institut;

    @Column(name = "description")
    private String description;

    @Column(name = "motdirecteur")
    private String motdirecteur;

    @Column(name = "agrement")
    private String agrement;

    @Column(name = "siege")
    private String siege;

    public Integer getId_institut() {
        return id_institut;
    }

    public void setId_institut(Integer id_institut) {
        this.id_institut = id_institut;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNomInstitut() {
        return nom_institut;
    }

    public void setNomInstitut(String nom) {
        this.nom_institut = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotDirecteur() {
        return motdirecteur;
    }

    public void setMotDirecteur(String mot) {
        this.motdirecteur = mot;
    }

    public String getAgrement() {
        return agrement;
    }

    public void setAgrement(String agrement) {
        this.agrement = agrement;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }
}
