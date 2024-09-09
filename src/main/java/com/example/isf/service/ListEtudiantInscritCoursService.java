package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.ListeEtudiantInscritCours;
import com.example.isf.repository.CoursRepository;
import com.example.isf.repository.ListeEtudiantInscritCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListEtudiantInscritCoursService {
    @Autowired
    private ListeEtudiantInscritCoursRepository listeEtudiantInscritCoursRepository;

    public List<ListeEtudiantInscritCours> Select_Liste_etudiant_By_idCours(int id) {
        return this.listeEtudiantInscritCoursRepository.selectCours_next_by_date(id);
    }
}
