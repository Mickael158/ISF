package com.example.isf.controller.Crud;

import com.example.isf.model.Semestre;
import com.example.isf.service.SemestreService;
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
@Controller
@RequestMapping("/Semestre")
public class SemestreController {
    @Autowired
    SemestreService semestreService;

    @PostMapping("/insertionSemestre")
    public ResponseEntity<HashMap> insertionSemestre(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String nsemestre = credentials.get("semestre");
        Semestre s = new Semestre();
        s.setSemestre(nsemestre);
        try {
            Semestre semestre = this.semestreService.enregistrerSemestre(s);
            result.put("data",semestre);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("SelectAll_Semestre")
    public ResponseEntity<HashMap> SelectAll_Semestre() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Semestre> semestres = this.semestreService.SelectAll_Semestre();
            result.put("data",semestres);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
