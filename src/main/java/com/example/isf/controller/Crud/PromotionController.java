package com.example.isf.controller.Crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.isf.model.Filiere;
import com.example.isf.model.Formation;
import com.example.isf.model.Promotion;
import com.example.isf.service.FiliereService;
import com.example.isf.service.FormationService;
import com.example.isf.service.PromotionService;

@Controller
@RequestMapping("/Promotion")
public class PromotionController {
    @Autowired
    PromotionService promotionService;

    @Autowired
    FiliereService filiereService;

    @Autowired
    FormationService formationService;

    @PostMapping("/insertionPromotion")
    public ResponseEntity<HashMap> insertionPromotion(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String codep = credentials.get("codep");
        String anne_promotion = credentials.get("anne_promotion");
        String filiere_id = credentials.get("filiere_id");
        String formation_id = credentials.get("formation_id");
        Optional<Filiere> filiere = this.filiereService.filiere_By_id(Integer.parseInt(filiere_id));
        Optional<Formation> formation = this.formationService.formation_by_id(Integer.parseInt(formation_id));
        Promotion p = new Promotion();
        p.setCodep(codep);
        p.setAnne_promotion(anne_promotion);
        p.setFiliere_id(filiere.get());
        p.setFormation_id(formation.get());
        try {
            Promotion promotion = this.promotionService.enregistrerPromotion(p);
            result.put("data",promotion);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/selectAll_Promotion")
    public ResponseEntity<HashMap> selectAll_Promotion() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Promotion> promotions = this.promotionService.selectAll_Promotion();
            result.put("data",promotions);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
