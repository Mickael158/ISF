package com.example.isf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isf.model.Filiere;
import com.example.isf.model.Formation;
import com.example.isf.repository.FiliereRepository;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere enregistrerFiliere(Filiere filiere) {
        return this.filiereRepository.save(filiere);
    }

    public List<Filiere> selectAll_Filiere() {
        return this.filiereRepository.findAll();
    }

    public Optional<Filiere> filiere_By_id(int  id) {
        return this.filiereRepository.findById(id);
    }
}
