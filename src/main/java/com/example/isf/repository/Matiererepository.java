package com.example.isf.repository;

import com.example.isf.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Matiererepository extends JpaRepository<Matiere, Integer> {
}
