package com.example.isf.repository;

import com.example.isf.model.PrixEcolage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PrixEcolageRepository extends JpaRepository<PrixEcolage , Integer> {
    @Query(value = """
   select * from prix_ecolage where dates=(select MAX(dates) from prix_ecolage where id_niveau=:id_niveau) ;
    """,nativeQuery = true)
    Optional<PrixEcolage> select_last_prix_ecolage_by_niveau(@Param("id_niveau") int id_niveau);

    @Query(value = """
            SELECT pe.*,n.nom FROM prix_ecolage pe
            LEFT JOIN niveaux n on n.id_niveaux = pe.id_niveau 
            WHERE pe.id_prix_ecolage = (
                SELECT MAX(pe2.id_prix_ecolage)
                FROM prix_ecolage pe2
                WHERE pe2.id_niveau = pe.id_niveau
            ) ORDER BY pe.id_niveau ASC;
            """,nativeQuery = true)
    List<PrixEcolage> Consultation();
}
