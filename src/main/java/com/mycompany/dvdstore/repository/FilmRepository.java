package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class FilmRepository implements FilmRepositoryInterface{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Film ajouter(Film film) {
        KeyHolder kh=new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt=connection.prepareStatement("INSERT INTO film (TITrE,GENRE,DESCRIPTION) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,film.getTitre());
            pstmt.setString(2,film.getGenre());
            pstmt.setString(3,film.getDescription());
            return pstmt;
        },kh);

        film.setId(kh.getKey().longValue());

        return film;
    }

    public List<Film> list() {
        return jdbcTemplate.query("select id,titre,genre from film",
                (rs,rownum)-> new Film(rs.getLong("id"),rs.getString("titre"),rs.getString("genre")));
    }

    public Film getById(long id) {
        return jdbcTemplate.queryForObject("select id,titre,genre,description from film where id=?", new Object[]{id},
                (rs,rownum)-> new Film(rs.getLong("id"),rs.getString("titre"),rs.getString("genre"), rs.getString("description")));
    }
}
