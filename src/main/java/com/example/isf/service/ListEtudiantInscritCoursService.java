package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.ListeEtudiantInscritCours;
import com.example.isf.repository.CoursRepository;
import com.example.isf.repository.ListeEtudiantInscritCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListEtudiantInscritCoursService {
    @Autowired
    private ListeEtudiantInscritCoursRepository listeEtudiantInscritCoursRepository;

    public List<ListeEtudiantInscritCours> Select_Liste_etudiant_By_idCours(int id) {
        return this.listeEtudiantInscritCoursRepository.selectCours_next_by_date(id);
    }

    public ListeEtudiantInscritCours Inscript_Liste_etudiant_By_idCours(ListeEtudiantInscritCours listeEtudiantInscritCours) {
        return this.listeEtudiantInscritCoursRepository.save(listeEtudiantInscritCours);
    }
}
