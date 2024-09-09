package com.example.isf.service;

import com.example.isf.model.Semestre;
import com.example.isf.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemestreService {
    @Autowired
    private SemestreRepository semestreRepository;

    public Semestre enregistrerSemestre(Semestre semestre) {
        return this.semestreRepository.save(semestre);
    }
}
