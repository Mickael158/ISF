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
   SELECT p.id_personne, p.nom, p.prenom, p.telephone, p.id_genre, p.email, p.adresse
FROM personne p
LEFT JOIN etudiant e ON p.id_personne = e.id_personne
LEFT JOIN professeur pr ON pr.id_personne = p.id_personne
WHERE e.id_personne IS NULL 
AND pr.id_personne IS NULL
AND p.email = :email;
    """,nativeQuery = true)
    Optional<Personne> select_personne_by_Email(@Param("email") String email);

    @Query(value = """
   select id_personne from personne where id_personne=(select MAX(id_Personne) from personne);
    """,nativeQuery = true)
    int select_personne_Max();
}
