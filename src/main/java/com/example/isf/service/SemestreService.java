package com.example.isf.service;

import com.example.isf.model.Semestre;
import com.example.isf.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {
    @Autowired
    private SemestreRepository semestreRepository;

    public Semestre enregistrerSemestre(Semestre semestre) {
        return this.semestreRepository.save(semestre);
    }

    public Optional<Semestre> select_Semestre_by_id(int id) {
        return this.semestreRepository.findById(id);
    }
}
