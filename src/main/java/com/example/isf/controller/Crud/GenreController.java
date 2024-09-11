package com.example.isf.controller.Crud;

import com.example.isf.model.Cours;
import com.example.isf.model.Genre;
import com.example.isf.model.Niveaux;
import com.example.isf.model.Promotion;
import com.example.isf.service.GenreService;
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
@RequestMapping("/Genre")
public class GenreController {
    @Autowired
    GenreService genreService;


    @PostMapping("/insertionCours")
    public ResponseEntity<HashMap> insertionGenre(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom = credentials.get("nom");
        Genre g = new Genre();
        g.setNom(nom);
        try {
            Genre genre = this.genreService.enregistreGenre(g);
            result.put("data",genre);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Genre")
    public ResponseEntity<HashMap> SelectAll_Genre() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Genre> genres = this.genreService.selectAll_Genre();
            result.put("data",genres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
