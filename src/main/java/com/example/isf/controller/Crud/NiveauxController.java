package com.example.isf.controller.Crud;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.isf.model.Niveaux;
import com.example.isf.service.NiveauService;

@Controller
@RequestMapping("/Niveaux")
public class NiveauxController {
    @Autowired
    NiveauService NiveauxService;

    @GetMapping("/selectAll_Niveaux")
    public ResponseEntity<HashMap> selectAll_Niveaux() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Niveaux> Niveauxs = this.NiveauxService.SelectAll_Niveaux();
            result.put("data",Niveauxs);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
