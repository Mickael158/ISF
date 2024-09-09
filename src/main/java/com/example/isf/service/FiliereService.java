package com.example.isf.service;

import com.example.isf.model.Filiere;
import com.example.isf.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere enregistrerFiliere(Filiere filiere) {
        return this.filiereRepository.save(filiere);
    }

    public Optional<Filiere> filiere_By_id(int  id) {
        return this.filiereRepository.findById(id);
    }
}
