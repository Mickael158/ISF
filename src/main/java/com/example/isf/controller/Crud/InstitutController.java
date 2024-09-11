package com.example.isf.controller.Crud;

import com.example.isf.model.Institut;
import com.example.isf.service.InstitutService;
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
@RequestMapping("/Institut")
public class InstitutController {
    @Autowired
    InstitutService institutService;
    @PostMapping("/insertionInstitut")
    public ResponseEntity<HashMap> insertionInstitut(@RequestBody Map<String, String> credentials) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        String logo = credentials.get("logo");
        Institut i = new Institut();
        i.setLogo(logo);
        try {
            Institut institut = this.institutService.enregistrerInstitut(i);
            result.put("data",institut);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e) {
            result.put("Erreur" , e.getMessage());
        }
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
