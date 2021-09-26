package com.mycompany.dvdstore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedEntityGraph(name = "film.acteur-and-reviews",attributeNodes = {@NamedAttributeNode("mainActeur"),@NamedAttributeNode("reviews")})
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String titre;
    @Column(nullable = false,length = 20)
    private String genre;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MAIN_ACTEUR")
    private Acteur mainActeur;

    @ManyToMany
    @JoinTable(
            name="FILM_SEC_ACTEURS",
            joinColumns = {@JoinColumn(name="ID_FILM")},
            inverseJoinColumns = {@JoinColumn(name="ID_ACTEUR")}
    )
    private List<Acteur> secondaryActeurs=new ArrayList<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "film"
    )
    private List<Review> reviews=new ArrayList<>();

    public Film() {
    }

    public Film(Long id, String titre, String genre, String description,Acteur mainActeur) {
        this.id = id;
        this.titre = titre;
        this.genre = genre;
        this.description = description;
        this.mainActeur = mainActeur;
    }

    public Film(Long id, String titre, String genre) {
        this.id = id;
        this.titre = titre;
        this.genre = genre;
    }


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
    public Acteur getMainActeur() {
        return mainActeur;
    }
    public void setMainActeur(Acteur mainActeur) {
        this.mainActeur = mainActeur;
    }
    public List<Acteur> getSecondaryActeurs() {
        return secondaryActeurs;
    }
    public void setSecondaryActeurs(List<Acteur> secondaryActeurs) {
        this.secondaryActeurs = secondaryActeurs;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
