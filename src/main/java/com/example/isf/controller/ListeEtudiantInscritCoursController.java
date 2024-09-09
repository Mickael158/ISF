package com.example.isf.controller;

import com.example.isf.model.Cours;
import com.example.isf.model.ListeEtudiantInscritCours;
import com.example.isf.model.Niveaux;
import com.example.isf.model.Promotion;
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


    @GetMapping("/Select_Liste_etudiant_By_idCours")
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
