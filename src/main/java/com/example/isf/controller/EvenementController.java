package com.example.isf.controller;

import com.example.isf.model.*;
import com.example.isf.repository.EvenementRepository;
import com.example.isf.service.EvenementService;
import com.example.isf.service.GenreService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/Evenement")
public class EvenementController {
    @Autowired
    EvenementService evenementService;

    private final String UPLOAD_DIR ="Uploads";


    @PostMapping(value = "/insertionEvenement", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HashMap> insertionEvenement(
            @RequestPart("credentials") String credentialsJson,
            @RequestParam(value = "image",required = false) List<MultipartFile> images) throws Exception {

        HashMap<String, Object> result = new HashMap<>();

        // Convertir la chaîne JSON en Map
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> credentials = objectMapper.readValue(credentialsJson, new TypeReference<Map<String, String>>() {});

        // Récupérer les valeurs à partir de la Map
        String date_evenement = credentials.get("date_evenement");
        String lieu_evenement = credentials.get("lieu_evenement");
        String decription = credentials.get("decription");
        String evenement = credentials.get("evenement");

        Evenement e = new Evenement();
        e.setEvenement(evenement);
        e.setLieu_evenement(lieu_evenement);
        e.setDate_evenement(Date.valueOf(date_evenement));
        e.setDecription(decription);

        try {
            List<String> imagesS = uploadFiles(images);
            String resultat = String.join(",", imagesS);
            e.setImage(resultat);

            Evenement evenements = this.evenementService.enregistrerEvenement(e);
            result.put("data", evenements);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            result.put("Erreur", ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<String> uploadFiles( List<MultipartFile> files) throws IOException {
        List<String> fileNames = new ArrayList<>();

        // Crée le répertoire s'il n'existe pas déjà
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        for (MultipartFile file : files) {
            // Obtenez le nom de fichier original
            String fileName = file.getOriginalFilename();

            // Crée le chemin complet pour le fichier
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            // Enregistrer le fichier dans le dossier
            file.transferTo(filePath);

            // Ajoutez le chemin relatif
            fileNames.add("/Uploads/"+fileName);
        }
        return fileNames;
    }



    @GetMapping("/SelectAll_Evenement")
    public ResponseEntity<HashMap> SelectAll_Etudiant() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Evenement> evenement = this.evenementService.SelectAllEvenement();
            result.put("data",evenement);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @GetMapping("/select_evenemet_proch")
    public ResponseEntity<HashMap> select_evenemet_proch() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Evenement> evenement = this.evenementService.select_evenemet_proch();
            result.put("data",evenement);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @PostMapping("/Delete_Evenemet/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteFiliere(@PathVariable("id") int id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            evenementService.deleteEvenement(id);
            result.put("data" , "Evenemet supprimer " );
        }
        catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
