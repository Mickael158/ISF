package com.example.isf.service;

import com.example.isf.model.Professeur_matiere;
import com.example.isf.repository.ProfesseurRepository;
import com.example.isf.repository.Professeur_matiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Professeur_matiereService {
    @Autowired
    private Professeur_matiereRepository professeur_matiereRepository;

    public Professeur_matiere enregistreProfesseur_matiere(Professeur_matiere professeur_matiere) {
        return this.professeur_matiereRepository.save(professeur_matiere);
    }

    public Optional<Professeur_matiere> Professeur_matiere_By_Id(int id) {
        return this.professeur_matiereRepository.findById(id);
    }

    public List<Professeur_matiere> SelectAll_Cours() {
        return this.professeur_matiereRepository.findAll();
    }

}
