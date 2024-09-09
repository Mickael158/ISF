package com.example.isf.service;

import com.example.isf.model.Personne;
import com.example.isf.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    public Optional<Personne> select_personne_by_Nom(String nom) {
        return this.personneRepository.select_personne_by_Nom(nom);
    }
    public Personne enregistrePersonne(Personne personne) {
        return this.personneRepository.save(personne);
    }

    public int PersonneMAX() {
        return this.personneRepository.select_personne_Max();
    }

    public Optional<Personne> Personne_by_id(int id) {
        return this.personneRepository.findById(id);
    }
}
