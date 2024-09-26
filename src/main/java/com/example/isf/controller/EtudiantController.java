package com.example.isf.controller;

import com.example.isf.model.*;
import com.example.isf.repository.EtudiantRepository;
import com.example.isf.service.EtudiantService;
import com.example.isf.service.GenreService;
import com.example.isf.service.PersonneService;
import com.example.isf.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/Etudiant")
public class EtudiantController {
    @Autowired
    PersonneService personneService;

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    PromotionService promotionService;
    @Autowired
    GenreService genreService;


    @PostMapping("/insertionEtudiant")
    public ResponseEntity<HashMap> insertionEtudiant(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom = credentials.get("nom");
        String prenom = credentials.get("prenom");
        String telephone = credentials.get("telephone");
        String email = credentials.get("email");
        String adresse = credentials.get("adresse");
        String matricule = credentials.get("matricule");
        String promotion_id = credentials.get("promotion_id");
        String id_genre = credentials.get("id_genre");
        String id_cours = credentials.get("id_cours"); 
        Optional<Promotion> promotion = this.promotionService.Promotion_By_id(Integer.parseInt(promotion_id));
        Optional<Genre> genre = this.genreService.Genre_By_Id(Integer.parseInt(id_genre));
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setTelephone(telephone);
        p.setId_genre(genre.get());
        p.setEmail(email);
        p.setAdresse(adresse);
        try {
            Personne personne = this.personneService.enregistrePersonne(p);
            int maxPersonne = this.personneService.PersonneMAX();
            Optional<Personne> personneMAx = this.personneService.Personne_by_id(maxPersonne);
            Etudiant e = new Etudiant();
            e.setMatricule(matricule);
            e.setId_personne(personneMAx.get());
            e.setPromotion_id(promotion.get());
            Etudiant etudiant = this.etudiantService.enregistreEtudiant(e);
            Optional<Etudiant> etudiantMax = this.etudiantService.select_etudiant_Max();
            result.put("data",etudiant);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Etudiant")
    public ResponseEntity<HashMap> SelectAll_Etudiant() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Etudiant> etudiants = this.etudiantService.selectAll_etudiant();
            result.put("data",etudiants);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/Select_Liste_etudiant_By_idCours/{id}")
    public ResponseEntity<HashMap> Select_Liste_etudiant_By_idCours(@PathVariable int id) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Etudiant> etudiants = this.etudiantService.select_etudiant_by_id_cours(id);
            result.put("data",etudiants);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping("/SelectAll_Etudiant_Promotion")
    public ResponseEntity<HashMap> SelectAll_Etudiant_Promotion(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        int id_promotion = Integer.parseInt(credentials.get("id_promotion"));
        try {
            List<Etudiant> etudiants = this.etudiantRepository.select_etudiant_by_Promotion(id_promotion);
            result.put("data",etudiants);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
