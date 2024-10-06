package com.example.isf.service;

import com.example.isf.model.Evenement;
import com.example.isf.model.Institut;
import com.example.isf.repository.EvenementRepository;
import com.example.isf.repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement enregistrerEvenement(Evenement evenement) {
        return this.evenementRepository.save(evenement);
    }

    public void deleteEvenement(int id) {
        evenementRepository.deleteById(id);
    }
    public List<Evenement> select_evenemet_proch() {
        return this.evenementRepository.select_evenemet_proch();
    }

    public List<Evenement> SelectAllEvenement(){
        return this.evenementRepository.findAll();
    }

}
