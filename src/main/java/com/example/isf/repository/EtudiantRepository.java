package com.example.isf.repository;

import com.example.isf.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant , Integer> {
    @Query(value = """
   select * from etudiant where matricule=:matricule;
    """,nativeQuery = true)
    Optional<Etudiant> select_etudiant_by_Matricule(@Param("matricule") String matricule);

    @Query(value = """
   select * from ETUDIANT where id_Etudiant=(select MAX(id_Etudiant) from ETUDIANT);
    """,nativeQuery = true)
    Optional<Etudiant> select_etudiant_Max();

    @Query(value = """
        select * from etudiant where promotion_id=:promotion_id;
         """,nativeQuery = true)
         List<Etudiant> select_etudiant_by_Promotion(@Param("promotion_id") int promotion_id);
}
