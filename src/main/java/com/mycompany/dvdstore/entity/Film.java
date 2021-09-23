package com.mycompany.dvdstore.entity;

public class Film {

    private Long id;
    private String titre;
    private String genre;
    private String description;

    public String getTitre() {
        return titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
