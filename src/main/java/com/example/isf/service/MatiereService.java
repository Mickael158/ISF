package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Matiere;
import com.example.isf.repository.Matiererepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {
    @Autowired
    private Matiererepository matiererepository;

    public Matiere enregistreMatiere(Matiere matiere) {
        return this.matiererepository.save(matiere);
    }

    public Optional<Matiere> Matiere_By_Id(int id) {
        return this.matiererepository.findById(id);
    }

    public List<Matiere> SelectAll_Matiere() {
        return this.matiererepository.findAll();
    }

}
