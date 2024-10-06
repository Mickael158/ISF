package com.example.isf.repository;

import com.example.isf.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement , Integer> {
    @Query(value = """
   select * from evenement where date_evenement >= NOW();
    """,nativeQuery = true)
    List<Evenement> select_evenemet_proch();
}
