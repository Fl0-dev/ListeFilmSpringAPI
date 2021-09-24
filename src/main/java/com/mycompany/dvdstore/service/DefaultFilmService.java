package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.repository.FilmRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFilmService implements FilmServiceInterface{

    //annotation Spring pour gérer les dépendances
    @Autowired
    private FilmRepositoryInterface filmRepository;

    public FilmRepositoryInterface getFilmRepository() {
        return filmRepository;
    }

    public void setFilmRepository(FilmRepositoryInterface filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film enregistrementFilm(Film film){
        filmRepository.save(film);
        return film;
    }

    @Override
    public Iterable<Film> getFilmList() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow();
    }


}
