package com.example.isf.service;

import com.example.isf.model.Institut;
import com.example.isf.repository.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutService {
    @Autowired
    private InstitutRepository institutRepository;

    public Institut enregistrerInstitut(Institut institut) {
        return this.institutRepository.save(institut);
    }
}
