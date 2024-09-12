package com.example.isf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isf.model.Promotion;
import com.example.isf.repository.PromotionRepository;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    public Promotion enregistrerPromotion(Promotion promotion) {
        return this.promotionRepository.save(promotion);
    }

    public Optional<Promotion> Promotion_By_id(int  id) {
        return this.promotionRepository.findById(id);
    }

    public List<Promotion> selectAll_Promotion() {
        return this.promotionRepository.findAll(); 
    }
}
