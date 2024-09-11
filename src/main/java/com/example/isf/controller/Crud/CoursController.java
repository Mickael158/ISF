package com.example.isf.controller.Crud;

import com.example.isf.model.Cours;
import com.example.isf.model.Niveaux;
import com.example.isf.model.Promotion;
import com.example.isf.service.CoursService;
import com.example.isf.service.NiveauService;
import com.example.isf.service.PromotionService;
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
@RequestMapping("/Cours")
public class CoursController {
    @Autowired
    CoursService coursService;

    @Autowired
    PromotionService promotionService;

    @Autowired
    NiveauService niveauService;


    @PostMapping("/insertionCours")
    public ResponseEntity<HashMap> insertionCours(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String date_debut = credentials.get("date_debut");
        String promotion_id = credentials.get("promotion_id");
        String date_fin = this.coursService.ajouterMois(date_debut , 10);
        Optional<Promotion> promotion = this.promotionService.Promotion_By_id(Integer.parseInt(promotion_id));
        Optional<Niveaux> niveaux = this.niveauService.select_New_Niveaux_promotion(Integer.parseInt(promotion_id));
        Cours c = new Cours();
        c.setDate_debut(Date.valueOf(date_debut));
        c.setDate_fin(Date.valueOf(date_fin));
        c.setPromotion_id(promotion.get());
        c.setId_niveaux(niveaux.get());
        try {
            Cours cours = this.coursService.enregistreCours(c);
            result.put("data",cours);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Cours")
    public ResponseEntity<HashMap> SelectAll_Cours() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Cours> cours = this.coursService.SelectAll_Cours();
            result.put("data",cours);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
