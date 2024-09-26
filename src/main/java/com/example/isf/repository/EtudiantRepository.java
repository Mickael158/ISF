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

    @Query(value = """
        select e.* from Liste_Etudiant_Inscrit_Cours leic\s
            join Etudiant e on e.id_Etudiant=leic.id_etudiant
            where id_cours=:id_cours;
         """,nativeQuery = true)
    List<Etudiant> select_etudiant_by_id_cours(@Param("id_cours") int id_cours);
}
