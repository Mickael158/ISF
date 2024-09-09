package com.example.isf.repository;

import com.example.isf.model.PrixEcolage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrixEcolageRepository extends JpaRepository<PrixEcolage , Integer> {
    @Query(value = """
   select * from prix_ecolage where dates=(select MAX(dates) from prix_ecolage where id_niveau=:id_niveau) ;
    """,nativeQuery = true)
    Optional<PrixEcolage> select_last_prix_ecolage_by_niveau(@Param("id_niveau") int id_niveau);
}
