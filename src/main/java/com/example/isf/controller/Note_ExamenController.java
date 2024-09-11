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
@RequestMapping("/Note_Examen")
public class Note_ExamenController {
    @Autowired
    Note_examenService note_examenService;

    @Autowired
    ExamenService examenService;

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    Professeur_matiereService professeur_matiereService;

    @PostMapping("/insertionEtudiant")
    public ResponseEntity<HashMap> insertionNote_Examen(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String id_examen = credentials.get("id_examen");
        String id_etudiant = credentials.get("id_etudiant");
        String id_professeur_matiere = credentials.get("id_professeur_matiere");
        String note = credentials.get("note");
        Optional<Examen> examen = this.examenService.Examen_By_Id(Integer.parseInt(id_examen));
        Optional<Etudiant> etudiant = this.etudiantService.select_etudiant_By_id(Integer.parseInt(id_etudiant));
        Optional<Professeur_matiere> professeur_matiere = this.professeur_matiereService.Professeur_matiere_By_Id(Integer.parseInt(id_professeur_matiere));
        Note_Examen ne = new Note_Examen();
        ne.setId_examen(examen.get());
        ne.setId_etudiant(etudiant.get());
        ne.setId_professeur_matiere(professeur_matiere.get());
        try {
            Note_Examen note_examen = this.note_examenService.enregistreNote_Examen(ne);
            result.put("data",note_examen);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Note_Examen")
    public ResponseEntity<HashMap> SelectAll_Note_Examen() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Note_Examen> note_examen = this.note_examenService.SelectAll_Note_Examen();
            result.put("data",note_examen);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
