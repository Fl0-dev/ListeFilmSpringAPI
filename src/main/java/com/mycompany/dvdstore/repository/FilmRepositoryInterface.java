package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepositoryInterface extends CrudRepository<Film,Long> {
    /*Film ajouter(Film film);
    List<Film> list();
    Film getById(long id);*/
}
