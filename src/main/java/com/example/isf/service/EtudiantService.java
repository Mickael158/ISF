package com.example.isf.service;

import com.example.isf.model.Etudiant;
import com.example.isf.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    public Optional<Etudiant> select_etudiant_by_Matricule(String matricule) {
        return this.etudiantRepository.select_etudiant_by_Matricule(matricule);
    }
    public Etudiant enregistreEtudiant(Etudiant etudiant) {
        return this.etudiantRepository.save(etudiant);
    }
}
