package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Matiere;
import com.example.isf.model.Niveaux;
import com.example.isf.repository.CoursRepository;
import com.example.isf.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauService {
    @Autowired
    private NiveauRepository niveauRepository;
    @Autowired
    private CoursRepository coursRepository;

    public Optional<Niveaux> Niveau_By_Id(int id) {
        return this.niveauRepository.findById(id);
    }

    public Optional<Niveaux> select_New_Niveaux_promotion(int id) {
        Optional<Cours> c = this.coursRepository.selectMax_by_promotion(id);
        if (c.isPresent()){
            if (c.get().getId_niveaux().getId_niveaux() < 3){
                int idMax = c.get().getId_niveaux().getId_niveaux();
                Optional<Niveaux> Newniveau = this.Niveau_By_Id(idMax + 1);
                return Newniveau;
            }
            else {
                return null;
            }
        }
        else {
            Optional<Niveaux> Newniveau = this.Niveau_By_Id(1);
            return Newniveau;
        }
    }

    public List<Niveaux> SelectAll_Niveaux() {
        return this.niveauRepository.findAll();
    }
}
