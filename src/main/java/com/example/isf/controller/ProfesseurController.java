package com.example.isf.controller;

import com.example.isf.model.*;
import com.example.isf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/Professeur")
public class ProfesseurController {
    @Autowired
    PersonneService personneService;

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    ProfesseurService professeurService;
    @Autowired
    GenreService genreService;


    @PostMapping("/insertionProfesseur")
    public ResponseEntity<HashMap> insertionProfesseur(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom = credentials.get("nom");
        String prenom = credentials.get("prenom");
        String telephone = credentials.get("telephone");
        String adresse = credentials.get("adresse");
        String email = credentials.get("email");
        String id_genre = credentials.get("id_genre");
        Optional<Genre> genre = this.genreService.Genre_By_Id(Integer.parseInt(id_genre));
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setTelephone(telephone);
        p.setEmail(email);
        p.setAdresse(adresse);
        p.setId_genre(genre.get());
        try {
            Personne personne = this.personneService.enregistrePersonne(p);
            int maxPersonne = this.personneService.PersonneMAX();
            Optional<Personne> personneMAx = this.personneService.Personne_by_id(maxPersonne);
            Professeur pr = new Professeur();
            pr.setId_personne(personneMAx.get());
            Professeur professeur = this.professeurService.enregistreProfesseur(pr);
            result.put("data",professeur);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @GetMapping("/SelectAll_Professeur")
    public ResponseEntity<HashMap> SelectAll_Professeur() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Professeur> professeurs = this.professeurService.SelectAll_Professeur();
            result.put("data",professeurs);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
