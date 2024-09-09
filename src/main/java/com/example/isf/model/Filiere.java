package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filiere", nullable = false)
    private Integer id_filiere;

    @Column(name = "codef")
    private String codef;

    @Column(name = "filiere")
    private String filiere;

    public Integer getId_filiere() {
        return id_filiere;
    }

    public void setId_filiere(Integer id_filiere) {
        this.id_filiere = id_filiere;
    }

    public String getCodef() {
        return codef;
    }

    public void setCodef(String codef) {
        this.codef = codef;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
