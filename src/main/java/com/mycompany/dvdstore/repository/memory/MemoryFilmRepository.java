package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.repository.FilmRepositoryInterface;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemoryFilmRepository implements FilmRepositoryInterface {

    private List<Film> films =new ArrayList<>();
    public static long lastId=10L;

    public Film save(Film film){
        film.setId(lastId++);
        films.add(film);
        System.out.printf("Le film %s a été ajouté.",film.getTitre());
        return film;
    }

    @Override
    public List<Film> findAll() {
        return films;
    }

    @Override
    public Iterable<Film> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Film> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Film> findById(Long id) {
        return films.stream().
                filter(m -> m.getId()==id).
                findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void delete(Film film) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Film> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {

    }


    @Override
    public Optional<Film> findById(long id) {
        return Optional.empty();
    }
}
