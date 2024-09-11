package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Professeur;
import com.example.isf.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    public Professeur enregistreProfesseur(Professeur professeur) {
        return this.professeurRepository.save(professeur);
    }

    public Optional<Professeur> Professeur_By_Id(int id) {
        return this.professeurRepository.findById(id);
    }

    public List<Professeur> SelectAll_Professeur() {
        return this.professeurRepository.findAll();
    }

}
