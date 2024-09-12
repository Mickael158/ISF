package com.example.isf.repository;

import com.example.isf.model.Professeur;
import com.example.isf.model.Professeur_matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
}
