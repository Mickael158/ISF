package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private NiveauService niveauRepository;

    public Cours enregistreCours(Cours cours) {
        return this.coursRepository.save(cours);
    }

    public Optional<Cours> Cours_By_Id(int id) {
        return this.coursRepository.findById(id);
    }

    public List<Cours> SelectAll_Cours() {
        return this.coursRepository.findAll();
    }

    public  String ajouterMois(String dateStr, int moisAAjouter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter); // Conversion de la chaîne en LocalDate
        LocalDate dateModifiee = date.plusMonths(moisAAjouter); // Ajout du nombre de mois

        return dateModifiee.format(formatter); // Retour de la nouvelle date sous forme de chaîne
    }
}
