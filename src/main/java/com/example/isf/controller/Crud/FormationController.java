package com.example.isf.controller.Crud;

import com.example.isf.model.Formation;
import com.example.isf.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Formation")
public class FormationController {
    @Autowired
    FormationService formationService;

    @PostMapping("/insertionFormation")
    public ResponseEntity<HashMap> insertionFormation(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom_formation = credentials.get("nom_formation");
        Formation f = new Formation();
        f.setNom_formation(nom_formation);
        try {
            Formation formation = this.formationService.enregistrerFormation(f);
            result.put("data",formation);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
