package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Examen;
import com.example.isf.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    public Examen enregistreExamen(Examen examen) {
        return this.examenRepository.save(examen);
    }

    public Optional<Examen> Examen_By_Id(int id) {
        return this.examenRepository.findById(id);
    }

    public List<Examen> SelectAll_Examen() {
        return this.examenRepository.findAll();
    }

}
