package com.example.isf.repository;

import com.example.isf.model.Cours;
import com.example.isf.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Integer> {
    @Query(value = """
   select * from cours where id_cours=(select MAX(id_cours) from cours where promotion_id=:promotion_id);
    """,nativeQuery = true)
    Optional<Cours> selectMax_by_promotion(@Param("promotion_id") int promotion_id);

    @Query(value = """
   SELECT C.id_Cours, C.Date_Debut, C.Date_Fin, N.id_niveaux, P.id_Promotion
   FROM COURS C
   JOIN niveaux N ON C.id_niveaux = N.id_niveaux
   JOIN promotion P ON C.Promotion_id = P.id_Promotion
   JOIN ETUDIANT E ON E.promotion_id = P.id_Promotion
   WHERE E.id_Etudiant = :etudiant_id
   AND P.id_Promotion = :promotion_id
   AND :date_cours BETWEEN C.Date_Debut AND C.Date_Fin;
   
    """,nativeQuery = true)
    Optional<Cours> selectCours_by_date(@Param("etudiant_id") int etudiant_id ,@Param("promotion_id") int promotion_id , @Param("date_cours") Date date_cours );

    @Query(value = """
   SELECT C.id_Cours, C.Date_Debut, C.Date_Fin, N.nom AS Niveaux, P.id_Promotion
   FROM COURS C
   JOIN niveaux N ON C.id_niveaux = N.id_niveaux
   JOIN promotion P ON C.Promotion_id = P.id_Promotion
   JOIN ETUDIANT E ON E.promotion_id = P.id_Promotion
   WHERE E.id_Etudiant = :etudiant_id
   AND P.id_Promotion = :promotion_id
   AND C.Date_Debut > :date_cours
   ORDER BY C.Date_Debut ASC
   LIMIT 1;
   
   
    """,nativeQuery = true)
    Optional<Cours> selectCours_next_by_date(@Param("etudiant_id") int etudiant_id ,@Param("promotion_id") int promotion_id , @Param("date_cours") Date date_cours );
}
