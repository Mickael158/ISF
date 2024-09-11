package com.example.isf.controller.Crud;

import com.example.isf.model.*;
import com.example.isf.service.MatiereService;
import com.example.isf.service.NiveauService;
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
@RequestMapping("/Matiere")
public class MatiereController {
    @Autowired
    MatiereService matiereService;


    @PostMapping("/insertionMatiere")
    public ResponseEntity<HashMap> insertionCours(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom_matiere = credentials.get("nom_matiere");
        String coeff = credentials.get("coeff");
        Matiere m = new Matiere();
        m.setNom_matiere(nom_matiere);
        m.setCoeff(Integer.parseInt(coeff));
        try {
            Matiere matiere = this.matiereService.enregistreMatiere(m);
            result.put("data",matiere);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Matiere")
    public ResponseEntity<HashMap> SelectAll_Matiere() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Matiere> matieres = this.matiereService.SelectAll_Matiere();
            result.put("data",matieres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
