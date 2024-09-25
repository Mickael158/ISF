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
@RequestMapping("/Personne")
public class PersonneController {
    @Autowired
    PersonneService personneService;

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    ProfesseurService professeurService;
    @Autowired
    GenreService genreService;


    @PostMapping("/insertionPersonne")
    public ResponseEntity<HashMap> insertionPersonne(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom = credentials.get("nom");
        String prenom = credentials.get("prenom");
        String telephone = credentials.get("telephone");
        String id_genre = credentials.get("id_genre");
        String adresse = credentials.get("adresse");
        String email = credentials.get("email");
        Optional<Genre> genre = this.genreService.Genre_By_Id(Integer.parseInt(id_genre));
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setTelephone(telephone);
        p.setAdresse(adresse);
        p.setEmail(email);
        p.setId_genre(genre.get());
        try {
            Personne personne = this.personneService.enregistrePersonne(p);
            result.put("data",personne);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @GetMapping("/SelectAll_Personne")
    public ResponseEntity<HashMap> SelectAll_Personne() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Personne> personnes = this.personneService.SelectAll_Personne();
            result.put("data",personnes);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
