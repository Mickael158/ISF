package com.example.isf.repository;

import com.example.isf.model.Niveaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveaux , Integer> {
}
