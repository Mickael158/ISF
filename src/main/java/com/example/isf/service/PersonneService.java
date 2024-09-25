package com.example.isf.service;

import com.example.isf.model.Matiere;
import com.example.isf.model.Personne;
import com.example.isf.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    public Optional<Personne> select_personne_by_Email(String nom) {
        return this.personneRepository.select_personne_by_Email(nom);
    }
    public Personne enregistrePersonne(Personne personne) {
        return this.personneRepository.save(personne);
    }

    public int PersonneMAX() {
        return this.personneRepository.select_personne_Max();
    }

    public List<Personne> SelectAll_Personne() {
        return this.personneRepository.findAll();
    }

    public Optional<Personne> Personne_by_id(int id) {
        return this.personneRepository.findById(id);
    }
}
