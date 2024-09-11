package com.example.isf.service;

import com.example.isf.model.Etudiant;
import com.example.isf.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Optional<Etudiant> select_etudiant_Max() {
        return this.etudiantRepository.select_etudiant_Max();
    }

    public Optional<Etudiant> select_etudiant_By_id(int id) {
        return this.etudiantRepository.findById(id);
    }

    public List<Etudiant> selectAll_etudiant() {
        return this.etudiantRepository.findAll();
    }
}
