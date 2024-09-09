package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etudiant", nullable = false)
    private Integer id_etudiant;

    @Column(name = "matricule")
    private String matricule;


    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne id_personne;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion_id;

    public Integer getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Integer id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Personne getId_personne() {
        return id_personne;
    }

    public void setId_personne(Personne id_personne) {
        this.id_personne = id_personne;
    }

    public Promotion getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Promotion promotion_id) {
        this.promotion_id = promotion_id;
    }
}
