package com.example.isf.service;

import com.example.isf.model.Formation;
import com.example.isf.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public Formation enregistrerFormation(Formation formation) {
        return this.formationRepository.save(formation);
    }

    public Optional<Formation> formation_by_id(int id) {
        return this.formationRepository.findById(id);
    }
}
