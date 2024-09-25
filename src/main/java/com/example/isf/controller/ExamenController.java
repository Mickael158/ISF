package com.example.isf.controller;

import com.example.isf.model.*;
import com.example.isf.service.CoursService;
import com.example.isf.service.ExamenService;
import com.example.isf.service.GenreService;
import com.example.isf.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/Examen")
public class ExamenController {
    @Autowired
    ExamenService examenService;

    @Autowired
    CoursService coursService;

    @Autowired
    SemestreService semestreService;


    @PostMapping("/insertionExamen")
    public ResponseEntity<HashMap> insertionExamen(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String date_debut = credentials.get("date_debut");
        String date_fin = credentials.get("date_fin");
        String cours_id = credentials.get("cours_id");
        String semestre_id = credentials.get("semestre_id");
        Optional<Cours> cours = this.coursService.Cours_By_Id(Integer.parseInt(cours_id));
        Optional<Semestre> semestre = this.semestreService.select_Semestre_by_id(Integer.parseInt(semestre_id));
        Examen e = new Examen();
        e.setDate_debut(Date.valueOf(date_debut));
        e.setDate_fin(Date.valueOf(date_fin));
        e.setCours_id(cours.get());
        e.setSemestre_id(semestre.get());
        try {
            Examen examen = this.examenService.enregistreExamen(e);
            result.put("data",examen);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception ex) {
            result.put("Erreur" , ex.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Examen")
    public ResponseEntity<HashMap> SelectAll_Etudiant() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Examen> examen = this.examenService.SelectAll_Examen();
            result.put("data",examen);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
