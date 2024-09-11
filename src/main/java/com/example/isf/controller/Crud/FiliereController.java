package com.example.isf.controller.Crud;

import com.example.isf.model.Filiere;
import com.example.isf.service.FiliereService;
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
@RequestMapping("/Filiere")
public class FiliereController {
    @Autowired
    FiliereService filiereService;

    @PostMapping("/insertionFiliere")
    public ResponseEntity<HashMap> insertionFiliere(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String codef = credentials.get("codef");
        String nfiliere = credentials.get("filiere");
        Filiere f = new Filiere();
        f.setCodef(codef);
        f.setFiliere(nfiliere);
        try {
            Filiere filiere = this.filiereService.enregistrerFiliere(f);
            result.put("data",filiere);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
