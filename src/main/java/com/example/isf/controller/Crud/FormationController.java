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

import com.example.isf.model.Formation;
import com.example.isf.model.Promotion;
import com.example.isf.service.FormationService;

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

    @GetMapping("/selectAll_Formation")
    public ResponseEntity<HashMap> selectAll_Formation() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Formation> formations = this.formationService.selectAll_formation();
            result.put("data",formations);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping("Delete_Formation")
    public ResponseEntity<HashMap<String, Object>> deleteFormation(@RequestBody Map<String, String> credentials) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            int idFormation = Integer.parseInt(credentials.get("id_formation"));
            Optional<Formation> formation = this.formationService.formation_by_id(idFormation);

            if (formation.isPresent()) {
                this.formationService.delete_formation(formation.get());
                result.put("message", "Formation supprimée avec succès");
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

}
