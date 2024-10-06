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
@RequestMapping("/Institut")
public class InstitutController {
    @Autowired
    InstitutService institutService;

    @GetMapping("/SelectAll_Intitut")
    public ResponseEntity<HashMap> SelectAll_Intitut() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Institut> instituts = this.institutService.SelectAllInstitut();
            result.put("data",instituts);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping("/Update_Intitut")
    public ResponseEntity<HashMap> Update_Intitut(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
        String nom = credentials.get("nom");
        String description = credentials.get("description");
        String agrement = credentials.get("agrement");
        String siege = credentials.get("siege");
        String mot = credentials.get("mot");
        int id_institut = Integer.parseInt(credentials.get("id_institut"));
            System.out.println("io pory"+agrement);
            this.institutService.ModificationInstitut(id_institut,nom,mot,siege,description,agrement);
            result.put("data","Institut modifier");
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
