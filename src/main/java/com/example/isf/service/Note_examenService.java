package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Note_Examen;
import com.example.isf.repository.Note_ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Note_examenService {
    @Autowired
    private Note_ExamenRepository note_examenRepository;

    public Note_Examen enregistreNote_Examen(Note_Examen note_examen) {
        return this.note_examenRepository.save(note_examen);
    }

    public Optional<Note_Examen> Note_Examen_By_Id(int id) {
        return this.note_examenRepository.findById(id);
    }

    public List<Note_Examen> SelectAll_Note_Examen() {
        return this.note_examenRepository.findAll();
    }

}
