package com.example.isf.controller;

import com.example.isf.model.Utilisateur;
import com.example.isf.repository.RoleRepository;
import com.example.isf.model.Personne;
import com.example.isf.model.Role;
import com.example.isf.service.PersonneService;
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
import java.util.Optional;

@Controller
@RequestMapping("/Utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    PersonneService personneService;

    @Autowired
    RoleRepository roleRepository;
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

    @PostMapping("/Inscription")
    public ResponseEntity<HashMap> InscriptionUtilisateur(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String email = credentials.get("email");
        String password = credentials.get("password");
        try{
            Optional<Personne> personne = this.personneService.select_personne_by_Email(email);
            if(personne.isPresent()){
                Optional<Role> role = this.roleRepository.findById(1);
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId_personne(personne.get());
                utilisateur.setIdrole(role.get());
                utilisateur.setPassword(password);
                Utilisateur utilisateurs = this.utilisateurService.Enregistrer(utilisateur);
                result.put("data",utilisateurs);
                return new ResponseEntity<>(result , HttpStatus.OK);
            }else{
                result.put("error","email non trouver !");
                return new ResponseEntity<>(result , HttpStatus.OK);
            }
            
        }catch(Exception e){
            result.put("Erreur", e.getMessage());
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
