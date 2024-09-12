package com.example.isf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isf.model.Formation;
import com.example.isf.repository.FormationRepository;
  
@Service
public class FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public Formation enregistrerFormation(Formation formation) {
        return this.formationRepository.save(formation);
    }

    public List<Formation> selectAll_formation() {
        return this.formationRepository.findAll();
    }

    public Optional<Formation> formation_by_id(int id) {
        return this.formationRepository.findById(id);
    }
}
