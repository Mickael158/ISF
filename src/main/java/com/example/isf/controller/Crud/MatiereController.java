package com.example.isf.controller.Crud;

import com.example.isf.model.*;
import com.example.isf.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/Matiere")
public class MatiereController {
    @Autowired
    MatiereService matiereService;


    @PostMapping("/insertionMatiere")
    public ResponseEntity<HashMap> insertionCours(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nom_matiere = credentials.get("nom_matiere");
        String coeff = credentials.get("coeff");
        Matiere m = new Matiere();
        m.setNom_matiere(nom_matiere);
        m.setCoeff(Integer.parseInt(coeff));
        try {
            Matiere matiere = this.matiereService.enregistreMatiere(m);
            result.put("data",matiere);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/SelectAll_Matiere")
    public ResponseEntity<HashMap> SelectAll_Matiere() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Matiere> matieres = this.matiereService.SelectAll_Matiere();
            result.put("data",matieres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping("/Delete_Matiere")
    public ResponseEntity<HashMap<String, Object>> deleteMatiere(@RequestBody Map<String, String> credentials) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            int id_matiere = Integer.parseInt(credentials.get("id_matiere"));
            Optional<Matiere> matiere = this.matiereService.Matiere_By_Id(id_matiere);

            if (matiere.isPresent()) {
                this.matiereService.delete_Matiere(matiere.get().getId_matiere());
                result.put("message", "Matiere supprimée avec succès");
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                result.put("message", "Formation non trouvée");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            result.put("Erreur", "ID de formation invalide");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            result.put("Erreur", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/Select_matiere_By_idCours/{id}")
    public ResponseEntity<HashMap> select_matiere_by_id_cours(@PathVariable int id) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Matiere> matieres = this.matiereService.select_matiere_by_id_cours(id);
            result.put("data",matieres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
