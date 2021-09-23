package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Film;

import java.util.List;

public interface FilmServiceInterface {
    Film enregistrementFilm(Film film);
    List<Film> getFilmList();

    Film getFilmById(Long id);
}


