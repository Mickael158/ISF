package com.example.isf.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evenement", nullable = false)
    private Integer id_evenement;

    @Column(name = "date_evenement")
    private Date date_evenement;

    @Column(name = "lieu_evenement")
    private String lieu_evenement;
    @Column(name = "decription")
    private String decription;

    @Column(name = "evenement")
    private String evenement;

    @Column(name = "image")
    private String image;

    public Integer getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(Integer id_evenement) {
        this.id_evenement = id_evenement;
    }

    public Date getDate_evenement() {
        return date_evenement;
    }

    public void setDate_evenement(Date date_evenement) {
        this.date_evenement = date_evenement;
    }

    public String getLieu_evenement() {
        return lieu_evenement;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setLieu_evenement(String lieu_evenement) {
        this.lieu_evenement = lieu_evenement;
    }

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
