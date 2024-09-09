package com.example.isf.repository;

import com.example.isf.model.Ecolage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EcolageRepository extends JpaRepository<Ecolage , Integer> {
    @Query(value = """
   select *
       from ECOLAGE
       where id_Ecolage = (select MAX(id_Ecolage) from ECOLAGE where Etudiant_id =:etudiant_id AND  id_Cours=:id_Cours)
    """,nativeQuery = true)
    Optional<Ecolage> select_Last_ecolage_payer_By_idEtudiant_IdCours(@Param("etudiant_id") int etudiant_id,@Param("id_Cours") int id_Cours);
}
