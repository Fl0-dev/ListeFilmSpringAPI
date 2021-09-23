package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.repository.FilmRepositoryInterface;


import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryFilmRepository implements FilmRepositoryInterface {

    private List<Film> films =new ArrayList<>();
    public static long lastId=10L;

    public Film ajouter(Film film){
        film.setId(lastId++);
        films.add(film);
        System.out.printf("Le film %s a été ajouté.",film.getTitre());
        return film;
    }

    @Override
    public List<Film> list() {
        return films;
    }

    @Override
    public Film getById(long id) {
        return films.stream().
                filter(m -> m.getId()==id).
                findFirst().get();
    }
}
