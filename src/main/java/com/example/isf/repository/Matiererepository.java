package com.example.isf.repository;

import com.example.isf.model.Etudiant;
import com.example.isf.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Matiererepository extends JpaRepository<Matiere, Integer> {
    @Query(value = """
        select m.* from professeur_matiere pm
            join matiere m on m.id_Matiere=pm.Matiere_id
            where pm.id_Cours=:id_Cours;
         """,nativeQuery = true)
    List<Matiere> select_matiere_by_id_cours(@Param("id_Cours") int id_cours);
}
