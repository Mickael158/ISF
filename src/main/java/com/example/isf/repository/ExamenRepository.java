package com.example.isf.repository;

import com.example.isf.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen , Integer> {

}
