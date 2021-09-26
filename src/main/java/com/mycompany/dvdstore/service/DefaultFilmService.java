package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.repository.FilmRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Transactional
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
        Optional<Film> optionalFilm=filmRepository.findById(id);
        if (optionalFilm.isEmpty()){
            throw new NoSuchElementException();
        }
        Film film=optionalFilm.get();
        //Initialize proxys
        film.getMainActeur().getFirstName();
        film.getReviews().forEach(review -> {
            review.setFilm(null);
        });
        //

        return film;
    }


}
