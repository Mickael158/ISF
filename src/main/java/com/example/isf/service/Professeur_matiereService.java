package com.example.isf.service;

import com.example.isf.model.Professeur_matiere;
import com.example.isf.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Professeur_matiereService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    public Professeur_matiere enregistreProfesseur_matiere(Professeur_matiere professeur_matiere) {
        return this.enregistreProfesseur_matiere(professeur_matiere);
    }

    public Optional<Professeur_matiere> Professeur_matiere_By_Id(int id) {
        return this.professeurRepository.findById(id);
    }

    public List<Professeur_matiere> SelectAll_Cours() {
        return this.professeurRepository.findAll();
    }

}
