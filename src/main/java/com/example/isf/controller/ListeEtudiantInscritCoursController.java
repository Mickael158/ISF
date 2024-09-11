package com.example.isf.controller;

import com.example.isf.model.*;
import com.example.isf.service.CoursService;
import com.example.isf.service.EtudiantService;
import com.example.isf.service.ListEtudiantInscritCoursService;
import com.example.isf.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/ListeEtudiantInscritCours")
public class ListeEtudiantInscritCoursController {
    @Autowired
    ListEtudiantInscritCoursService listEtudiantInscritCoursService;

    @Autowired
    CoursService coursService;

    @Autowired
    EtudiantService etudiantService;

    @PostMapping("/insertionListeEtudinatCours")
    public ResponseEntity<HashMap> insertionEtudiantByCours(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String id_cours = credentials.get("id_cours");
        String id_etudiant = credentials.get("id_etudiant");
        Optional<Cours> cours = this.coursService.Cours_By_Id(Integer.parseInt(id_cours));
        Optional<Etudiant> etudiant = this.etudiantService.select_etudiant_By_id(Integer.parseInt(id_etudiant));
        ListeEtudiantInscritCours leic = new ListeEtudiantInscritCours();
        leic.setId_cours(cours.get());
        leic.setId_etudiant(etudiant.get());
        try {
            ListeEtudiantInscritCours listeEtudiantInscritCours = this.listEtudiantInscritCoursService.Inscript_Liste_etudiant_By_idCours(leic);
            result.put("data",listeEtudiantInscritCours);
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
            List<ListeEtudiantInscritCours> listeEtudiantInscritCours = this.listEtudiantInscritCoursService.Select_Liste_etudiant_By_idCours(id);
            result.put("data",listeEtudiantInscritCours);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
