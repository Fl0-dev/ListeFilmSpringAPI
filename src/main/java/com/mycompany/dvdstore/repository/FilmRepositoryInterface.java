package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Film;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface FilmRepositoryInterface extends CrudRepository<Film,Long> {
   /* Film ajouter(Film film);

    List<Film> list();*/
    @EntityGraph(value = "movie.actor-and-reviews", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Film> findById(long id);
}
