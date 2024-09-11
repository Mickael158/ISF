package com.example.isf.controller.Crud;

import com.example.isf.model.Niveaux;
import com.example.isf.model.PrixEcolage;
import com.example.isf.service.NiveauService;
import com.example.isf.service.PrixEcolageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/Cours")
public class PrixEcolageController {
    @Autowired
    PrixEcolageService prixEcolageService;

    @Autowired
    NiveauService niveauService;


    @PostMapping("/insertionPrixEcolage")
    public ResponseEntity<HashMap> insertionPrixEcolage(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String valeur = credentials.get("valeur");
        String id_niveau = credentials.get("id_niveau");
        Optional<Niveaux> niveaux = this.niveauService.Niveau_By_Id(Integer.parseInt(id_niveau));
        PrixEcolage pe = new PrixEcolage();
        pe.setId_niveau(niveaux.get());
        pe.setDates(new Date(new java.util.Date().getTime()));
        pe.setValeur(Double.parseDouble(valeur));
        try {
            PrixEcolage prixEcolage = this.prixEcolageService.enregistrePrixEcolage(pe);
            result.put("data",prixEcolage);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
