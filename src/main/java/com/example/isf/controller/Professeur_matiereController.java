package com.example.isf.controller;

import com.example.isf.model.*;
import com.example.isf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/Professeur_matiere")
public class Professeur_matiereController {
    @Autowired
    Professeur_matiereService professeur_matiereService;

    @Autowired
    ProfesseurService professeurService;

    @Autowired
    MatiereService matiereService;

    @Autowired
    CoursService coursService;


    @PostMapping("/insertionProfesseur_matiere")
    public ResponseEntity<HashMap> insertionProfesseur_matiere(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String professeur_id = credentials.get("professeur_id");
        String matiere_id = credentials.get("matiere_id");
        String id_cours = credentials.get("id_cours");
        Optional<Professeur> professeur= this.professeurService.Professeur_By_Id(Integer.parseInt(professeur_id));
        Optional<Matiere> matiere = this.matiereService.Matiere_By_Id(Integer.parseInt(matiere_id));
        Optional<Cours> cours = this.coursService.Cours_By_Id(Integer.parseInt(id_cours));
        Professeur_matiere pm = new Professeur_matiere();
        pm.setProfesseur_id(professeur.get());
        pm.setMatiere_id(matiere.get());
        pm.setId_cours(cours.get());
        try {
            Professeur_matiere professeur_matiere = this.professeur_matiereService.enregistreProfesseur_matiere(pm);
            result.put("data",professeur_matiere);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_ProfesseurMatiere")
    public ResponseEntity<HashMap> SelectAll_ProfesseurMatiere() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Professeur_matiere> professeur_matieres = this.professeur_matiereService.SelectAll_Cours();
            result.put("data",professeur_matieres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
