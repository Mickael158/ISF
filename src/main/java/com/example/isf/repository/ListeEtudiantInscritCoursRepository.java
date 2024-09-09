package com.example.isf.repository;

import com.example.isf.model.Cours;
import com.example.isf.model.ListeEtudiantInscritCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ListeEtudiantInscritCoursRepository extends JpaRepository<ListeEtudiantInscritCours, Integer> {
    @Query(value = """
   select p.Nom , e.Matricule
       from Liste_Etudiant_Inscrit_Cours l
           join ETUDIANT e on e.id_Etudiant=l.id_etudiant
           join personne p on e.id_personne = p.id_personne
           join COURS C2 on l.id_cours = C2.id_Cours
       where l.id_cours=:id_cours;
   
    """,nativeQuery = true)
    List<ListeEtudiantInscritCours> selectCours_next_by_date(@Param("id_cours") int id_cours);
}
