package com.example.isf.repository;

import com.example.isf.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    @Query(value = """
   select * from personne where nom=:nom;
    """,nativeQuery = true)
    Optional<Personne> select_personne_by_Nom(@Param("nom") String nom);

    @Query(value = """
   select id_personne from personne where id_personne=(select MAX(id_Personne) from personne);
    """,nativeQuery = true)
    int select_personne_Max();
}
