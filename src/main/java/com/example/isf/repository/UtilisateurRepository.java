package com.example.isf.repository;

import com.example.isf.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer> {
    @Query(value = """
   select * from utilisateur where id_personne=:id_personne AND password=:password;
    """,nativeQuery = true)
    Optional<Utilisateur> select_utilisateur_by_Personne_Pswd(@Param("id_personne") int  id_personne , @Param("password") String  password);
}
