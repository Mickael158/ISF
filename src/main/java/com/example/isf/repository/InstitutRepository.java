package com.example.isf.repository;

import com.example.isf.model.Institut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface InstitutRepository extends JpaRepository<Institut , Integer> {
    @Query(value = """
            UPDATE institut set 
            nom_institut = :nom, 
            description = :description, 
            motdirecteur = :mot,
            agrement = :agrement,
            siege = :siege where id_institut = :id;
            """,nativeQuery = true)
            void UpdateInstitut(@Param("nom") String nom,@Param("description") String description,@Param("mot") String mot,@Param("agrement") String agrement,@Param("siege") String siege,@Param("id") int id);
}
