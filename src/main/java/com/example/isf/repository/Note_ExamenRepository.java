package com.example.isf.repository;

import com.example.isf.model.Note_Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Note_ExamenRepository extends JpaRepository<Note_Examen , Integer> {
}
