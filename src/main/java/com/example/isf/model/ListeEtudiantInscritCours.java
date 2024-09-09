package com.example.isf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Liste_Etudiant_Inscrit_Cours")
public class ListeEtudiantInscritCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liste_etudiant_inscrit_cours", nullable = false)
    private Integer id_liste_etudiant_inscrit_cours;

    @ManyToOne
    @JoinColumn(name = "id_cours")
    private Cours id_cours;

    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant id_etudiant;

    public Integer getId_liste_etudiant_inscrit_cours() {
        return id_liste_etudiant_inscrit_cours;
    }

    public void setId_liste_etudiant_inscrit_cours(Integer id_liste_etudiant_inscrit_cours) {
        this.id_liste_etudiant_inscrit_cours = id_liste_etudiant_inscrit_cours;
    }

    public Cours getId_cours() {
        return id_cours;
    }

    public void setId_cours(Cours id_cours) {
        this.id_cours = id_cours;
    }

    public Etudiant getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Etudiant id_etudiant) {
        this.id_etudiant = id_etudiant;
    }
}
