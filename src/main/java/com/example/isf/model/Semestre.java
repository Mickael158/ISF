package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "semestre")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semestre", nullable = false)
    private Integer id_semestre;

    @Column(name = "semestre")
    private String semestre;

    public Integer getId_semestre() {
        return id_semestre;
    }

    public void setId_semestre(Integer id_semestre) {
        this.id_semestre = id_semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
