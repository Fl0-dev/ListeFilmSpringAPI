package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.service.FilmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FilmServiceInterface filmService;

    public FilmServiceInterface getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmServiceInterface filmService) {
        this.filmService = filmService;
    }

    @RequestMapping("/dvdstore-home")//indique vers quelle url
    public @ModelAttribute("films") List<Film> displayHome(){ //indique qu'il y aura une liste de films en objet
        System.out.println(filmService.getFilmList());
        //récupération des films et
        //envoie en attribut de la requête l'objet
        return filmService.getFilmList();
    }
}
