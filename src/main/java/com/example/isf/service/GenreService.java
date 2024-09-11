package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Genre;
import com.example.isf.repository.CoursRepository;
import com.example.isf.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;


    public Genre enregistreGenre(Genre genre) {
        return this.genreRepository.save(genre);
    }

    public Optional<Genre> Genre_By_Id(int id) {
        return this.genreRepository.findById(id);
    }
    public List<Genre> selectAll_Genre() {
        return this.genreRepository.findAll();
    }
}
