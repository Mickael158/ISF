package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promotion", nullable = false)
    private Integer id_promotion;

    @Column(name = "codep")
    private String codep;

    @Column(name = "anne_promotion")
    private String anne_promotion;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere_id;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation_id;

    public Integer getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(Integer id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getCodep() {
        return codep;
    }

    public void setCodep(String codep) {
        this.codep = codep;
    }

    public String getAnne_promotion() {
        return anne_promotion;
    }

    public void setAnne_promotion(String anne_promotion) {
        this.anne_promotion = anne_promotion;
    }

    public Filiere getFiliere_id() {
        return filiere_id;
    }

    public void setFiliere_id(Filiere filiere_id) {
        this.filiere_id = filiere_id;
    }

    public Formation getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(Formation formation_id) {
        this.formation_id = formation_id;
    }
}
