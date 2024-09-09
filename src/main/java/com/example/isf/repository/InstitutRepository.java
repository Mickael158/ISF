package com.example.isf.repository;

import com.example.isf.model.Institut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InstitutRepository extends JpaRepository<Institut , Integer> {
}
