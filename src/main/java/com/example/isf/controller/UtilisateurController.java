package com.example.isf.controller;

import com.example.isf.model.Utilisateur;
import com.example.isf.service.UtilisateurService;
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
@RequestMapping("/Utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;
    @PostMapping("/checking")
    public ResponseEntity<HashMap> checking(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String matricule = credentials.get("user");
        String pswd = credentials.get("psw");
        try {
            Utilisateur utilisateur = this.utilisateurService.login(matricule , pswd);
            if (utilisateur != null) {
                result.put("data",utilisateur);
                return new ResponseEntity<>(result , HttpStatus.OK);
            }
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
