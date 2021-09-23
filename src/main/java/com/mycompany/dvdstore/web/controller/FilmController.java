package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.service.FilmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;


@Controller
public class FilmController {

    //annotation Spring pour gérer les dépendances
    @Autowired
    private FilmServiceInterface filmService;

    public FilmServiceInterface getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmServiceInterface filmService) {
        this.filmService = filmService;
    }

    public void ajouterUsingConsole(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est le titre du film à enregistrer ?");
        String filmTitre = sc.nextLine();
        System.out.println("Quel est son genre ?");
        String filmGenre = sc.nextLine();
        Film film = new Film();
        film.setTitre(filmTitre);
        film.setGenre(filmGenre);
        filmService.enregistrementFilm(film);
    }
}
