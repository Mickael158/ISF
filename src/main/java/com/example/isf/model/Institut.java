package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "institut")
public class Institut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_institut", nullable = false)
    private Integer id_institut;

    @Column(name = "logo")
    private String logo;

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
}
