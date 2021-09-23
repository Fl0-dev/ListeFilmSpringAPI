package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Film;

import java.util.List;

public interface FilmRepositoryInterface {
    Film ajouter(Film film);
    List<Film> list();
    Film getById(long id);
}
