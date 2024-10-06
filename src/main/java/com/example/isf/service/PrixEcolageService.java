package com.example.isf.service;

import com.example.isf.model.PrixEcolage;
import com.example.isf.repository.PrixEcolageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PrixEcolageService {
    @Autowired
    private PrixEcolageRepository prixEcolageRepository;

    public PrixEcolage enregistrePrixEcolage(PrixEcolage prixEcolage) {
        return this.prixEcolageRepository.save(prixEcolage);
    }

    public List<PrixEcolage> Consultation(){
        return this.prixEcolageRepository.Consultation();
    }
}
