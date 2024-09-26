package com.example.isf.controller.Crud;

import com.example.isf.model.Filiere;
import com.example.isf.model.Formation;
import com.example.isf.model.Genre;
import com.example.isf.service.FiliereService;
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

    @GetMapping("/SelectAll_Filiere")
    public ResponseEntity<HashMap> SelectAll_Genre() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Filiere> filieres = this.filiereService.selectAll_Filiere();
            result.put("data",filieres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @PostMapping("/Delete_Filiere")
    public ResponseEntity<HashMap<String, Object>> deleteFiliere(@RequestBody Map<String, String> credentials) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            int idfiliere = Integer.parseInt(credentials.get("id_filiere"));
            Optional<Filiere> filiere = this.filiereService.filiere_By_id(idfiliere);

            if (filiere.isPresent()) {
                this.filiereService.delete_by_id(filiere.get().getId_filiere());
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
