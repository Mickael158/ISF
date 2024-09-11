package com.example.isf.repository;

import com.example.isf.model.Professeur_matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Professeur_matiereRepository extends JpaRepository<Professeur_matiere , Integer> {
}
