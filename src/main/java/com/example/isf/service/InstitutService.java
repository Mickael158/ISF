package com.example.isf.service;

import com.example.isf.model.Institut;
import com.example.isf.repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutService {
    @Autowired
    private InstitutRepository institutRepository;

    public Institut enregistrerInstitut(Institut institut) {
        return this.institutRepository.save(institut);
    }

    public List<Institut> SelectAllInstitut(){
        return this.institutRepository.findAll();
    }

    public void ModificationInstitut(int id,String nom,String mot,String siege,String description,String agrement) {
       this.institutRepository.UpdateInstitut(nom,description,mot,agrement,siege,id);
    }
}
