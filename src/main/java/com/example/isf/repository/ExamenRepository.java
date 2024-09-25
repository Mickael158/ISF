package com.example.isf.repository;

import com.example.isf.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Repository
public interface ExamenRepository extends JpaRepository<Examen , Integer> {
    @Query(value = """
   SELECT ex.id_examen,C.id_cours,E.id_etudiant,E.matricule,Pe.nom,Pe.prenom,P.codep,Se.semestre FROM examen ex
    LEFT JOIN Cours C on C.id_cours = ex.cours_id
    LEFT JOIN Promotion P on P.id_promotion = C.promotion_id
    LEFT JOIN Etudiant E on E.promotion_id = P.id_promotion
    LEFT JOIN Personne Pe on Pe.id_personne = E.id_personne
    LEFT JOIN Semestre Se on Se.id_semestre = ex.semestre_id
    WHERE ex.id_examen = :id_examen;
    """,nativeQuery = true)
    Optional<Examen> select_Etudiant_By_Examen(@Param("id_examen") int  id_examen);
}
